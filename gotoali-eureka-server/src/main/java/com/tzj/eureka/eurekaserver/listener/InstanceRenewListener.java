package com.tzj.eureka.eurekaserver.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author TianZiJiang
 * @date 2019-07-27
 */
@Configuration
@Slf4j
public class InstanceRenewListener implements ApplicationListener<EurekaInstanceRenewedEvent> {
    @Override
    public void onApplicationEvent(EurekaInstanceRenewedEvent eurekaInstanceRenewedEvent) {
        log.info("心跳检测：{}", eurekaInstanceRenewedEvent.getAppName());
    }
}
