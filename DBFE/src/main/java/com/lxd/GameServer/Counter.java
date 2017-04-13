package com.lxd.GameServer;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by luoxiaodong on 2017/4/11.
 */
public class Counter implements Runnable {
    private BlockingQueue<Page> queue;

    private ConcurrentHashMap<String, Integer> counts;

    public Counter(BlockingQueue<Page> queue)
    {
        this.queue = queue;
    }

    public void run() {
        while (true)
        {
            Page page = null;
            try {
                page = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (page.isPointPill())
            {
                break;
            }

            Thread.currentThread().interrupt();
            CyclicBarrier xx = new CyclicBarrier(1);

            Iterable<String> Words = new Words(page.getText());
            for (String word : Words)
            {
                Integer currentCount = counts.get(word);
                if (currentCount == null)
                {
                    counts.putIfAbsent(word, 1);
                }
                else
                {
                    counts.replace(word, currentCount, currentCount + 1);
                }
            }
        }
    }
}
