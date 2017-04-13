package com.lxd.GameServer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by luoxiaodong on 2017/4/11.
 */
public class Parser implements Runnable{
    private BlockingQueue<Page> queue;

    public Parser(BlockingQueue<Page> queue)
    {
        this.queue = queue;
    }

    public void run()
    {
        try
        {
            Iterable<Page> pages = new Pages(1000, "enWiki.xml");
            for (Page page : pages)
            {
                queue.put(page);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
