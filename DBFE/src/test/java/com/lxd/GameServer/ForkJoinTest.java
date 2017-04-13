package com.lxd.GameServer;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by luoxiaodong on 2017/4/11.
 */
public class ForkJoinTest {
    public static void main(String[] args)
    {
        final int SIZE = 1000000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++)
        {
            numbers[i] = Math.random();
        }

        Counter1 couter = new Counter1(numbers, 0, numbers.length,
                new Filter1()
                {
                    public boolean accept(double t)
                    {
                        return t > 0.5;
                    }
                });

        ForkJoinPool pool;
        pool = new ForkJoinPool();
        pool.invoke(couter);
        System.out.println(couter.join());
    }
}
