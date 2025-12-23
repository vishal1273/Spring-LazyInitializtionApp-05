package com.vishal.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        // Logic
        System.out.println("Some Initialization Logic...");
        this.classA = classA;
    }
    public void doSomeThing(){
        System.out.println("Do Something....");
    }

}

@Configuration
@ComponentScan
public class LazyInitializationApp {
    public static void main(String[] args) {
        try (
                AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LazyInitializationApp.class);
        ) {
            System.out.println("Initialization of context is completed...");
            context.getBean(ClassB.class).doSomeThing();
        }
    }
}