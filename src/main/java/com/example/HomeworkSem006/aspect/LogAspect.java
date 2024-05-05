package com.example.HomeworkSem006.aspect;


//Домашнее задание выполнить для одного из пройденных семинаров в проекте с Базой Данных.
// Вам необходимо разработать механизм регистрации действий пользователя в вашем Spring Boot приложении.
// Используйте Spring AOP для создания журнала действий, в котором будет сохраняться информация о том,
// какие методы сервиса вызывались, кем и с какими параметрами.​
//
//Создайте аннотацию @TrackUserAction.
//        Реализуйте aspect, который будет регистрировать действия пользователя, когда вызывается метод, отмеченный этой аннотацией.
//Примените аннотацию @TrackUserAction к нескольким методам в слое сервиса.
//Результаты регистрации в консоль​

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    @Around(value = "@annotation(log)")
    public Object toLog(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("=======================================================================");

        String methodName = jp.getSignature().getName();
        System.out.println("Run: "+ methodName);

        Object [] arguments = jp.getArgs();
        System.out.println("Args "+ Arrays.asList(arguments));

        System.out.println("=======================================================================");
        return jp.proceed();
    }
}
