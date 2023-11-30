package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class SecondAspect {
   // @Pointcut("execution(* org.example.test.*.main(..))")
    public void pc1(){

    }
   /* @Before("pc1()")
    public void beforeMain(){
        System.out.println("*******************************************");
        System.out.println("Before main from Aspect with Class syntax");
        System.out.println("*******************************************");
    }
    @After("pc1()")
    public void afterMain(){
        System.out.println("*******************************************");
        System.out.println("After main from Aspect with Class syntax");
        System.out.println("*******************************************");
    }

    @Around("pc1()")
    public void arroundMain(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("*******************************************");
        System.out.println("Before main from Aspect with Class syntax");
        System.out.println("*******************************************");
        // Exécution la méthode main
        proceedingJoinPoint.proceed();
        System.out.println("*******************************************");
        System.out.println("After main from Aspect with Class syntax");
        System.out.println("*******************************************");
    }*/
}
