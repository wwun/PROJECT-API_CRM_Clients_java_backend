package com.william.crm.clients.crm_clients.aops;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditPointcuts {

    @Pointcut("execution(* com.william.crm.clients.crm_clients.services.ClientServiceImpl.*(..))")
    public void auditLoggerPointcut(){}
}
