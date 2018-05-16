package com.vironit.pharmacy.aspect;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DaoLoggingAspect {

    private Logger logger;
    private String currentMethod,currentClass;

    @Before("execution(* com.vironit.pharmacy.dao..*(..))")
    public void doBeforeTask(JoinPoint joinPoint){
        currentMethod = joinPoint.getSignature().toShortString();
        currentClass = joinPoint.getTarget().getClass().toString();
        logger = LogManager.getLogger(joinPoint.getTarget().getClass());
        logger.info("Method " + currentMethod + " in class " + currentClass + " starting executing");
    }

    @After("execution(* com.vironit.pharmacy.dao..*(..))")
    public void doAfterTask(JoinPoint joinPoint){
        logger.info("Method " + currentMethod + " in class " + currentClass + " ended executing");
    }


    @AfterThrowing(pointcut = "execution(* com.vironit.pharmacy.dao..*(..))", throwing = "ex")
    public void doAfterThrowingTask(Exception ex) {
        logger.debug("Method " + currentMethod + " in class " + currentClass + " throw exception");
    }
}
