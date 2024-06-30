package com.task.ecommerce.common.aspect;

import com.task.ecommerce.common.logger.CommonPerformanceLoggerAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServicePerformanceAspect extends CommonPerformanceLoggerAspect {
    @Pointcut("execution(public * com.task.ecommerce.repository..*.*(..))")
    public void userRepositoryPerformanceTrace() {}

    @Around("userRepositoryPerformanceTrace()")
    public Object calculateUserServicePerformance(ProceedingJoinPoint joinPoint) throws Throwable{
        return tracePerformance(joinPoint);
    }
}
