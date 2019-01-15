package com.cynen.jdk8.defaultable;

public class TestMain {
    public static void main( String[] args ) {

        // 默认使用DefaulableFactory 的静态方法创建一个实例.
        // 传递的是 DefaultableImpl 接口.
        Defaultable defaulable = DefaulableFactory.create( DefaultableImpl::new );
        // 实际调用的是当前接口或者其父类的接口中的指定方法.
        System.out.println( defaulable.notRequired());

        // 指定要创建的类为 OverridableImpl
        defaulable = DefaulableFactory.create( OverridableImpl::new );
        // 调用的具体的方法是其本身或者向上查找到的父类的方法, 有override,以就近原则为主.
        System.out.println( defaulable.notRequired() );
    }

}
