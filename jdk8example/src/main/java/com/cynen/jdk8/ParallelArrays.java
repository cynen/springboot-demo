package com.cynen.jdk8;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Java8版本新增了很多新的方法，用于支持并行数组处理。
 * 最重要的方法是parallelSort()，可以显著加快多核机器上的数组排序。
 * 下面的例子论证了parallexXxx系列的
 *
 *  这些代码使用parallelSetAll()方法生成20000个随机数，然后使用parallelSort()方法进行排序。
 *  这个程序会输出乱序数组和排序数组的前10个元素。
 */
public class ParallelArrays {
    public static void main( String[] args ) {
        long[] arrayOfLong = new long [ 20000 ];

        // 设置值.
        Arrays.parallelSetAll( arrayOfLong, index -> ThreadLocalRandom.current().nextInt( 1000000 ) );

        //乱序数组前10个元素
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach(
                i -> System.out.print( i + " " ) );
        System.out.println();

        // 排序数组的前10个元素
        Arrays.parallelSort( arrayOfLong );
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach(
                i -> System.out.print( i + " " ) );
        System.out.println();
    }
}
