package com.tzj.controller.service.impl;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.tzj.controller.feign.FeignService;
import com.tzj.controller.feign.FeignServiceService;
import com.tzj.controller.service.RedisFeignService;
import com.tzj.controller.vo.ResultVo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author TianZiJiang
 * @date 2019-08-30
 */
@Slf4j
@Service
public class RedisFeignServiceImpl implements RedisFeignService {

    @Autowired
    private FeignService feignService;

    @Autowired
    private FeignServiceService feignServiceService;

    private static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("redis-%d").build();

    /**
     * 线程池
     */
    private static ExecutorService executorService = new ThreadPoolExecutor(1000, 5000, 0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(10000), threadFactory, new ThreadPoolExecutor.AbortPolicy());

    @Override
    public ResultVo setRedis(String name, String value) {
        ResultVo resultVo = feignService.testRedisSet(name, value);
        return resultVo;
    }


    @Override
    public ResultVo findUserById(Integer usetId) {
        if (usetId == null) {
            return ResultVo.ofError("userId不能为空");
        }

        List<UserServiceJob> userServiceJobs = new LinkedList<>();
        long l = System.currentTimeMillis();

        for (int i = 0; i < 5000; i++){
            UserServiceJob userServiceJob = new UserServiceJob();
            userServiceJob.setFeignServiceService(feignServiceService);
            userServiceJob.setUsetId(usetId);
            userServiceJobs.add(userServiceJob);
        }
        System.out.println(System.currentTimeMillis() - l);

        // 模拟并发请求
        try {
            executorService.invokeAll(userServiceJobs);
        } catch (InterruptedException e) {
            log.error("并发请求出错！{}", e);
            return ResultVo.ofError("并发请求出错！");
        }

        ResultVo user = feignServiceService.findUserById(usetId);

        return ResultVo.ofSuccess("查询成功！", user.getData());
    }

    @Setter
    @Getter
    @ToString
    static class UserServiceJob implements Callable<ResultVo> {

        private FeignServiceService feignServiceService;

        private Integer usetId;



        @Override
        public ResultVo call() throws Exception {
            ResultVo user = feignServiceService.findUserById(usetId);
            return user;
        }
    }
}
