package com.cynen.jdk8;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional仅仅是一个容器：存放T类型的值或者null。它提供了一些有用的接口来避免显式的null检查
 *
 * 所以 Optional 的关键点在于确保开发者不用查阅 Javadoc 就能知道某个方法可以返回 null，
 * 或者可以把一个 null 值传给某方法
 *
 * Java 8 的 Optional 类通过减少空指针错误相关的缺陷简化了代码编写，同时 Spring 能很好地支持 Java 8 的 Optional 类。
 */
public class OptionalTest {

    /**
     * 如果Optional实例持有一个非空值，则isPresent()方法返回true，否则返回false；
     * orElseGet()方法，Optional实例持有null，则可以接受一个lambda表达式生成的默认值；
     * map()方法可以将现有的Opetional实例的值转换成新的值；
     * orElse()方法与orElseGet()方法类似，但是在持有null的时候返回传入的默认值。
     */
    @Test
    public void test(){
        Optional< String > fullName = Optional.ofNullable( null );
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
    }

    @Test
    public void optional_01(){
        Optional< String > firstName = Optional.of( "Tom" );
        System.out.println( "First Name is set? " + firstName.isPresent() ); // 判断是否为空
        System.out.println( "First Name: " + firstName.orElseGet( () -> "[none]" ) ); // 如果为空就赋值 [none]
        System.out.println( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
    }


}
