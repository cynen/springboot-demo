package com.cynen.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 演示JDK8的新特性.Lambda表达式
 */
public class JDK8Lambda {

    /**
     * foreach的参数是一个Consumer.
     */
    @Test
    public void jdk8_01(){
        // 最简单的Lambda表达式可由逗号分隔的参数列表、->符号和语句块组成，例如：
        Arrays.asList("1","2","B","4").forEach(e->System.out.println(e));
        // 在上面这个代码中的参数e的类型是由编译器推理得出的，你也可以显式指定该参数的类型，例如
        Arrays.asList("1","2","B","4").forEach((String e)->System.out.println(e)); // 指定参数类型

        // 和上面的语句等价
        // Arrays.asList("1","2","B","4").forEach(System.out::println);
    }

    /**
     * 复杂参数可以使用中括号
     */
    @Test
    public void jdk8_02(){
        // 如果Lambda表达式需要更复杂的语句块，则可以使用花括号将该语句块括起来，类似于Java中的函数体
        Arrays.asList("1","2","B","4").forEach(e->{
            System.out.println(e);
            System.out.println(e);
        });
    }


    @Test
    public void jdk8_03(){
        // Lambda表达式可以引用类成员和局部变量（会将这些变量隐式得转换成final的），例如下列两个代码块的效果完全相同
        String separator = ",";
        Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.print( e + separator ));

/*
        final String separator = ",";
        Arrays.asList( "a", "b", "d" ).forEach(
                ( String e ) -> System.out.print( e + separator ) );*/
    }

    @Test
    public void jdk8_04(){
        // Lambda表达式可以引用类成员和局部变量（会将这些变量隐式得转换成final的），例如下列两个代码块的效果完全相同
        List<String> list = Arrays.asList( "c", "g", "b" ,"a");
        list.sort( (e1, e2 ) -> e1.compareTo( e2 ));
        list.forEach(System.out::println);

        /*
        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
            int result = e1.compareTo( e2 );
            return result;
        } );
        * */
    }








}
