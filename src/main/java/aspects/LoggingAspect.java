package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    //@Pointcut("call(* metier.MetierBanqueImpl.*(..))")
    //long t1;
    Logger logger = Logger.getLogger(LoggingAspect.class.getName());
    public LoggingAspect() throws IOException {
        logger.addHandler(new FileHandler("log.txt"));
        logger.setUseParentHandlers(false);
    }
   @Pointcut("execution(* metier.MetierBanqueImpl.*(..)) || initialization(metier.MetierBanqueImpl.new(..))")
    public void pc1() {
    }
 /*
    @Before("pc1()")
    public void avant(JoinPoint joinPoint) {
        t1 = System.currentTimeMillis();
        logger.info("*******************************************");
        logger.info("Avant l'exécution de la méthode : " + joinPoint.getSignature().getName());
    }

    @After("pc1()")
    public void apres(JoinPoint joinPoint) {
        logger.info("Après l'exécution de la méthode : " + joinPoint.getSignature().getName());
        logger.info("Durée d'exécution de la méthode : " + (System.currentTimeMillis() - t1) + " ms");
        logger.info("*******************************************");
    }*/

    @Around("pc1()")
    public Object autour(ProceedingJoinPoint proceedingJoinPoint,JoinPoint joinPoint) throws Throwable {
        long t1 = System.currentTimeMillis();
        logger.info("*******************************************");
        logger.info("Avant l'exécution de la méthode : " + joinPoint.getSignature().getName());
        Object o=proceedingJoinPoint.proceed();
        logger.info("Après l'exécution de la méthode : " + joinPoint.getSignature().getName());
        logger.info("Durée d'exécution de la méthode : " + (System.currentTimeMillis() - t1) + " ms");
        logger.info("*******************************************");
        return o;
    }


}
