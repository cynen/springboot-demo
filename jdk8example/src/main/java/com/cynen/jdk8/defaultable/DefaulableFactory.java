package com.cynen.jdk8.defaultable;

import java.util.function.Supplier;


/**
 * Java 8带来的另一个有趣的特性是在接口中可以定义静态方法
 */
public interface DefaulableFactory {
    // Interfaces now allow static methods
    static Defaultable create( Supplier< Defaultable > supplier ) {
        return supplier.get();
    }
}
