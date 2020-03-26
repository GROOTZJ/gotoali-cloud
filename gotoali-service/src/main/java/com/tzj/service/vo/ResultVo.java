package com.tzj.service.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回result类
 *
 * @author TianZiJiang
 * @date 2019-08-25
 */
@Data
public class ResultVo<T> implements Serializable {

    private static final long serialVersionUID = -8195688935022569303L;
    /**
     * 成功
     */
    public static final String SUCCESS = "SUCCESS";

    /**
     * 失败
     */
    public static final String ERROR = "ERROR";

    private String code;
    private String msg;
    private T data;

    /**
     * 为空不参加序列化
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer pageNum;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer pageSize;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer currentPage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer totalPage;

    public static <T> ResultVo ofSuccess(String msg, T data) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(SUCCESS);
        resultVo.setMsg(msg);
        resultVo.setData(data);
        return resultVo;
    }

    public static ResultVo ofSuccess(String msg) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(SUCCESS);
        resultVo.setMsg(msg);
        resultVo.setData(null);
        return resultVo;
    }

    public static ResultVo ofError(String msg) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(ERROR);
        resultVo.setMsg(msg);
        resultVo.setData(null);
        return resultVo;
    }

}
