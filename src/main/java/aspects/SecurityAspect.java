package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Scanner;

@Aspect
public class SecurityAspect {
    @Pointcut("execution(* org.example.test.Application.start(..))")
    public void startAppPointcut() {
    }

    @Around("startAppPointcut()")
    public void autourStartApp(ProceedingJoinPoint proceedingJoinPoint, JoinPoint joinPoint) throws Throwable {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username : ");
        String username = scanner.next();
        System.out.println("Password : ");
        String password = scanner.next();
        if (username.equals("root") && password.equals("1234")){
            proceedingJoinPoint.proceed();
        }else {
            System.out.println("Access Denied ...");
        }
    }
}
