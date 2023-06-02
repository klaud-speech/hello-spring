package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around( "execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint jointPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println(("START: " + jointPoint.toLongString()));
        try {
            return jointPoint.proceed();
        }
        finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + jointPoint.toLongString() + " " + timeMs + "ms");
        }

    }
}

//다음으로.... 유료 동영상 수강...zz
