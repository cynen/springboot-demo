package com.cynen.jdk8.defaultable;


/**
 * Defaulable接口使用关键字default定义了一个默认方法notRequired()。
 * DefaultableImpl类实现了这个接口，同时默认继承了这个接口中的默认方法；
 * OverridableImpl类也实现了这个接口，但覆写了该接口的默认方法，并提供了一个不同的实现。
 */
public class OverridableImpl implements Defaultable{

    /**
     * 接口提供的默认方法会被接口的实现类继承或者覆写
     * @return
     */
    @Override
    public String notRequired() {
        return "Overridden implementation";
    }
}
