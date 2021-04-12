package aoptest.aspect;

import aoptest.game.pojo.Role;
import aoptest.verifier.RoleVerifier;
import aoptest.verifier.impl.RoleVerifierImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class RoleAspect {

    @DeclareParents(value = "aoptest.service.impl.RoleServiceImpl+", defaultImpl = RoleVerifierImpl.class)
    public RoleVerifier roleVerifier;

    @Pointcut("execution(* aoptest.service.impl.RoleServiceImpl.printRole(..))")
    public void print() {
    }

    @Before("print()")
    public void before() {
        System.out.println("before...");
    }

    @After("print()")
    public void after() {
        System.out.println("after...");
    }

    @AfterReturning("print()")
    public void afterReturnint() {
        System.out.println("afterReturning...");
    }

    @AfterThrowing("print()")
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }

    @Around("print()")
    public void around(ProceedingJoinPoint jp) {
        System.out.println("around before...");
        try {
            jp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around after...");
    }

    @Before("execution(* aoptest.service.impl.RoleServiceImpl.printRole(..))"+"&& args(role,sort)")
    public void before(Role role, int sort) {
        System.out.println("before...");
    }


}
