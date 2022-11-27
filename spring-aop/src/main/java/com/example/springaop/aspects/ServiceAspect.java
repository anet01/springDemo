package com.example.springaop.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {


    /**
     * Alabileceği anatasyonlar
     *   @AftefReturning
     *   @AfterThrowing
     *   @After
     *   @Before
     *   @EnableAspectJAutoProxy
     *   @Aspect
     */

    //JoinPoint state yakalar kim çağırdı parametre ne vs.
    @Before("execution(* com.example.springaop.service.*.*(..))")
    public void mesajVerdenOnce(JoinPoint joinPoint){
        System.out.println("Mesaj ver metodundan önce parametre yakalandı: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* com.example.springaop.service.*.*(..))")
    public void mesajVerdenSonra(JoinPoint joinPoint){
        System.out.println("Mesaj ver metodundan sonra parametre yakalandı: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
