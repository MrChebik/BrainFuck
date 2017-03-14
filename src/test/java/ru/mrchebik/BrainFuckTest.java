package ru.mrchebik;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

/**
 * Created by mrchebik on 14.03.17.
 */
public class BrainFuckTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testHelloWorld() {
        BrainFuck.brainfuck("++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.");
        assertEquals("H -- (72)\n" +
                "e -- (101)\n" +
                "l -- (108)\n" +
                "l -- (108)\n" +
                "o -- (111)\n" +
                "  -- (32)\n" +
                "W -- (87)\n" +
                "o -- (111)\n" +
                "r -- (114)\n" +
                "l -- (108)\n" +
                "d -- (100)\n" +
                "! -- (33)\n" +
                "\n" +
                " -- (10)\n", log.getLog());
    }
}