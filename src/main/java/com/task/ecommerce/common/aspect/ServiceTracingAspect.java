package com.task.ecommerce.common.aspect;

import com.task.ecommerce.common.logger.CommonTraceLoggerAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceTracingAspect extends CommonTraceLoggerAspect {
    @Pointcut("execution(* com.task.ecommerce.api..*(..)))")
    public void controllerAspect() {}

    @Pointcut("execution(* com.task.ecommerce.service..*.*(..)))")
    public void serviceTrace(){}

    @Around("serviceTrace() && !noLogging()")
    public Object logService(ProceedingJoinPoint joinPoint) throws Throwable {
        return trace(joinPoint);
    }

    @Around("controllerAspect()")
    public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {
        return trace(joinPoint);
    }
}
