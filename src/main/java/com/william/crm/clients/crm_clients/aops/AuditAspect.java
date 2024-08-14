package com.william.crm.clients.crm_clients.aops;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    public static final Logger logger = LoggerFactory.getLogger(AuditAspect.class);

    @Around("AuditPointcuts.auditLoggerPointcut()")
    public Object auditLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        try{
            String methodName = proceedingJoinPoint.getSignature().getName();
            Object[] args = proceedingJoinPoint.getArgs();

            String user = "anonymous";

            logger.info("user ["+user+"] executed ["+methodName+"] with arguments "+Arrays.toString(args));

            return proceedingJoinPoint.proceed();
        }catch(Throwable e){
            throw e;
        }
    }
}
