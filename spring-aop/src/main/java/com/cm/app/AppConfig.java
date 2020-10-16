package com.cm.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.cm")
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class AppConfig {

}
