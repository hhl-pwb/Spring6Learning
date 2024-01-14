package com.atguigu.spring6.aop.xmlaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
//切面类

@Component //表示将该类交给ioc容器管理
public class LogAspect {

    //前置通知
    @Before(value = "execution(* com.atguigu.spring6.aop.xmlaop.CalculationImpl.*(..)))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger->前置通知，方法名称：" + methodName + "，参数：" + Arrays.toString(args));
    }

    // 返回
    @AfterReturning(value = "execution(* com.atguigu.spring6.aop.xmlaop.CalculationImpl.*(..)))", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger->前置通知，方法名称：" + methodName + "，返回结果：" + result);
    }

    // 异常
    @AfterThrowing(value = "execution(* com.atguigu.spring6.aop.xmlaop.CalculationImpl.*(..))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知，方法名称：" + methodName + "，异常信息：" + ex);
    }

    // 后置
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->后置通知，方法名称：" + methodName);
    }
    // 环绕 @Around()
    @Around(value = "execution(* com.atguigu.spring6.aop.xmlaop.CalculationImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argString = Arrays.toString(args);
        Object result = null;
        try {
            System.out.println("环绕通知==目标方法之前执行");
            //调用目标方法
            result = joinPoint.proceed();
            System.out.println("环绕通知==目标方法返回值之后执行");
        }catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("环绕通知==目标方法出现异常执行");
        }finally {
            System.out.println("环绕通知==目标方法执行完毕执行");
        }
        return result;
    }

    //重用切入点表达式
    @Pointcut(value = "execution(* com.atguigu.spring6.aop.xmlaop.CalculationImpl.*(..))")
    public void pointCut(){}
}
