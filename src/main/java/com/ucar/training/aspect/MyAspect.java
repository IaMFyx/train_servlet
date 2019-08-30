package com.ucar.training.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    @Pointcut("execution(* com.ucar.training.service.*.*(..))")
    private void myPointCut(){

    }
    @Around("myPointCut()")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long beforeTime=System.currentTimeMillis();
        Object object=proceedingJoinPoint.proceed();
        long afterTime=System.currentTimeMillis();
        System.out.println("执行时间："+(afterTime-beforeTime)+"ms");
        return object;
    }
}
