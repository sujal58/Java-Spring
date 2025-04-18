package org.example.logging;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    @Before("execution(* org.example.services.UserService.loginUser(..))")
    public void beforeLogin(){
        System.out.println("Advice called before login is executed.");
    }

    @After("execution(* org.example.services.UserService.loginUser(..))")
    public void afterLogin(){
        System.out.println("Advice called after login is executed.");
    }

    @Around("execution(* org.example.services.UserService.loginUser())")
    public Object whileLogin(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before login");
        try{
            Object result = joinPoint.proceed();
            System.out.println("After login(success)");
            return result;
        }catch (Throwable ex){
            System.out.println("After login (failed): " + ex.getMessage());
            throw ex;
        }

    }

    @AfterThrowing(value = "execution(* org.example.services.UserService.loginUser())", throwing = "ex")
    public void afterException(Throwable ex){
        System.out.println("Exception is Occurred while logging in users.");
    }

    @AfterReturning("execution(* org.example.services.UserService.loginUser())")
    public void afterLoginReturn(){
        System.out.println("logged in successfully.");
    }

    @Pointcut("execution(* org.example.services.UserService.loginUser())")
    public void pointCut1(){

    }

    @Pointcut("execution(* org.example.services.UserService.loginUser())")
    public void pointCut2(){

    }

    @Before("pointCut1() || pointCut2()")
    public void userMethod(){
        //do what you want to perform when one of the pointcut method is satisfied
    }


//    @AfterReturning
//    @Pointcut
}
