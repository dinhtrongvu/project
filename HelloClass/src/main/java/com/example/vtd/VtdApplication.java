package com.example.vtd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class VtdApplication {

    public static void main(String[] args) {

        SpringApplication.run(VtdApplication.class, args);
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloClazz obj = (HelloClazz) context.getBean("helloclass");// lấy message mặc địnhtrong bean.xml khi k truyền.
        HelloClazz objInit = (HelloClazz) context.getBean("bean3");
//        obj.setMsg("chào anh");
        objInit.printMsg();
        obj.printMsg();
        System.out.println("===============================");
        HelloClazz obj3 = (HelloClazz) context.getBean("testscope");
        obj3.printMsg();
        System.out.println(obj3);

        HelloClazz obj4 = (HelloClazz) context.getBean("testscope");
        obj3.printMsg();
        System.out.println(obj3 == obj4);
        System.out.println("===============================");
        HelloClazz obj5 = (HelloClazz) context.getBean("testprototype");
        obj5.printMsg();
        System.out.println(obj5);

        HelloClazz obj6 = (HelloClazz) context.getBean("testprototype");
        obj6.printMsg();
        System.out.println(obj5 == obj6);

        System.out.println("===============================");


    }

}
