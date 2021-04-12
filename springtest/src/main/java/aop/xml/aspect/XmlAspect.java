package aop.xml.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class XmlAspect {

    public void before() {
        System.out.println("before...");
    }

    public void after() {
        System.out.println("after...");
    }

    public void afterThrowing() {
        System.out.println("after-throwing...");
    }

    public void afterReturning() {
        System.out.println("after-returning...");
    }

    public void around(ProceedingJoinPoint jp) {
        System.out.println("around before...");
        try {
            jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around after...");
    }
}
