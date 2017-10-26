package iris.tdd.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringTool {

    @Test
    public void test() {
        assertEquals((char) ('A' + 1) + "", "B");
    }

}
