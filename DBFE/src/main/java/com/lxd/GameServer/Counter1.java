package com.lxd.GameServer;

import java.util.concurrent.RecursiveTask;

interface Filter1
{
    boolean accept(double t);
}
/**
 * Created by luoxiaodong on 2017/4/11.
 */
public class Counter1 extends RecursiveTask<Integer>{
    public static final int THRSHOLD = 1000;
    private double[] values;
    private int from;
    private int to;
    private Filter1 filter;
    public Counter1(double[] numbers, int from, int to, Filter1 filter)
    {
        this.values = numbers;
        this.from = from;
        this.to = to;
        this.filter = filter;
    }

    protected Integer compute()
    {
        if (to - from < THRSHOLD)
        {
            int count = 0;
            for (int i = from; i < to; i++)
            {
                if (filter.accept(values[i]))
                {
                    count++;
                }
            }

            return count;
        }
        else
        {
            int mid = (from + to) / 2;
            Counter1 first = new Counter1(values, from, mid, filter);
            Counter1 second = new Counter1(values, from, mid, filter);
            invokeAll(first, second);
            return first.join() + second.join();
        }
    }
}
