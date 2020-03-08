package cn.xyz.test;


import cn.xyz.service.UserImpl;
import cn.xyz.service.User;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestUser {


    //没用spring调用user方法的代码写法
    @Test
    public void test1(){
        User user = new UserImpl();
        user.add();
    }

    //没用spring调用user方法的代码写法 new两次对象地址不一样
    @Test
    public void test2(){
        User user = new UserImpl();
        user.add();
        User user2 = new UserImpl();
        user2.add();

        System.out.println(user);
        System.out.println(user2);
    }

    //用spring容器调用 userimpl add方法
    @Test
    public void test3(){
        /**
         * 加载beans.xml spring配置文件
         *
         * */
       // System.out.println(new ClassPathXmlApplicationContext());
       ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");

        //从spring容器中获取user对象
        User user= (User) context.getBean("User");
        user.add();

        //从spring容器中获取user对象
        User user2= (User) context.getBean("User");
        user2.add();

        System.out.println("user地址："+user);
        System.out.println("user2地址："+user2);
    }





}
