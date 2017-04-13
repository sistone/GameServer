package com.lxd.GameServer;

import java.util.HashMap;

/**
 * Created by luoxiaodong on 2017/4/11.
 */
public class WordCount {
    private static final HashMap<String, Integer> counts = new HashMap<String, Integer>();

    public static void main(String[] args)
    {
        Iterable<Page> pages = new Pages(100, "enWiki.xml");
        for (Page page : pages)
        {
            Iterable<String> words = new Words(page.getText());
            for (String word : words) {
                countWord(word);
            }
        }
    }

    public static void countWord(String word)
    {
        Integer currentCount = counts.get(word);
        if (currentCount == null)
        {
            counts.put(word, 1);
        }
        else
        {
            counts.put(word, currentCount + 1);
        }
    }
}
