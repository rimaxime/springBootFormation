package com.example.aspects;

import com.example.annotation.LogMethod;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogMethodAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(@com.example.annotation.LogMethod * *(..))")
    public void auditLog() {
        //nothing to do there
    }

    @Around("auditLog() && @annotation(logMethodAnnotation)")
    public Object logAround(ProceedingJoinPoint joinPoint, LogMethod logMethodAnnotation) throws Throwable {
        LOGGER.info(String.format("Log Message: %s", logMethodAnnotation.value()));
        LOGGER.info(String.format("Method Called: %s", joinPoint.getSignature().getName()));
        Object[] args = joinPoint.getArgs();
        StringBuilder argsString = new StringBuilder("|");
        for (Object arg : args) {
            argsString.append(arg).append("|");
        }
        LOGGER.info(String.format("Method Parameters: %s", argsString.toString()));
        Object proceed = joinPoint.proceed();
        return proceed;
    }

}
