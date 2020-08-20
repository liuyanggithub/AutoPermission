package com.example.asmhelp;

import org.junit.Test;

import java.util.TreeMap;
import java.util.function.BiConsumer;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        TreeMap<String,String> map = new TreeMap<String,String>();
        map.put("EmotionUI_2.0.0","ROM");
        map.put("EmotionUI_9.0","ROM");
        map.put("EmotionUI_8.1.0","ROM");
        map.put("EmotionUI_10.0.0","ROM");
        map.put("EmotionUI_6.6.0","ROM");
        map.put("EmotionUI_8.2.0","ROM");
        map.put("EmotionUI_8.6.0","ROM");
        map.put("EmotionUI_8.4.0","ROM");
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println("=== "+s+" === "+s2);
            }
        });

        assertEquals(4, 2 + 2);
    }
}