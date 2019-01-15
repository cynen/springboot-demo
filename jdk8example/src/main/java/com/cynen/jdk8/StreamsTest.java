package com.cynen.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *新增的Stream API（java.util.stream）将生成环境的函数式编程引入了Java库中。
 * 这是目前为止最大的一次对Java库的完善，以便开发者能够写出更加有效、更加简洁和紧凑的代码。
 */
public class StreamsTest {
    private enum Status {
        OPEN, CLOSED
    };

    private static final class Task {
        private final Status status;
        private final Integer points;

        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }


    /**
     * 首先，tasks集合被转换成steam表示；
     * 其次，在steam上的filter操作会过滤掉所有CLOSED的task；
     * 第三，mapToInt操作基于每个task实例的Task::getPoints方法将task流转换成Integer集合；
     * 最后，通过sum方法计算总和，得出最后的结果。
     */
    @Test
    public void test(){
        final Collection< Task > tasks = Arrays.asList(
                new Task( Status.OPEN, 5 ),
                new Task( Status.OPEN, 13 ),
                new Task( Status.CLOSED, 8 )
        );
        long total = tasks.stream() // 构建一个输入流
                .filter(task -> task.status == Status.OPEN) // 根据规则过滤
                .mapToInt(Task::getPoints)  //
                .sum();
        // System.out.println(tasks.stream().count());
        System.out.println("Total Point : "+total);
    }

    /**
     * Steam之上的操作可分为中间操作和晚期操作。
     *
     * 中间操作会返回一个新的steam——执行一个中间操作（例如filter）并不会执行实际的过滤操作，
     * 而是创建一个新的steam，并将原steam中符合条件的元素放入新创建的steam。
     *
     * 晚期操作（例如forEach或者sum），会遍历steam并得出结果或者附带结果；
     * 在执行晚期操作之后，steam处理线已经处理完毕，就不能使用了。
     * 在几乎所有情况下，晚期操作都是立刻对steam进行遍历。
     */

    /**
     * steam的另一个价值是创造性地支持并行处理（parallel processing）。
     * 对于上述的tasks集合，我们可以用下面的代码计算所有任务的点数之和
     */
    @Test
    public void test2(){
        final Collection< Task > tasks = Arrays.asList(
                new Task( Status.OPEN, 5 ),
                new Task( Status.OPEN, 13 ),
                new Task( Status.CLOSED, 8 )
        );
        double totalPoints  = tasks.stream() // 构建一个输入流
                .parallel() // 开启并行计算.
                .map(Task::getPoints)
                .reduce(0,Integer::sum); // 求和汇总
        // System.out.println(tasks.stream().count());
        System.out.println("Total Point : "+totalPoints );
    }


    /**
     * 对于一个集合，经常需要根据某些条件对其中的元素分组。
     * 利用steam提供的API可以很快完成这类任务，
     */
    @Test
    public void test3(){
        final Collection< Task > tasks = Arrays.asList(
                new Task( Status.OPEN, 5 ),
                new Task( Status.OPEN, 13 ),
                new Task( Status.CLOSED, 8 )
        );
        Map<Status, List<Task>> listMap = tasks.stream()
                .collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(listMap);
    }


    @Test
    public void test4(){
        final Collection< Task > tasks = Arrays.asList(
                new Task( Status.OPEN, 5 ),
                new Task( Status.OPEN, 13 ),
                new Task( Status.CLOSED, 8 )
        );
        final double totalpoints = tasks.stream().parallel().map(task -> task.getPoints())
                .reduce(0, Integer::sum);

        Collection<String> list = tasks.stream()
                .mapToInt(Task::getPoints)  // 获得 IntStream
                .asLongStream()
                .mapToDouble(points -> points / totalpoints)
                .boxed()
                .mapToLong(w -> (long) (w * 100))
                .mapToObj(percent -> percent + "%")
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
