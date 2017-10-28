package cyber.dojo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CountCoinsTest {
    //[1, 5, 10, 25]
    @Test
    public void should_return_1_when_count_given_1() {
        //given
        int input = 1;
        //when
        int result = CountCoins.count(input);
        int expected = 1;
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_1_when_count_given_3() {
        //given
        int input = 3;
        //when
        int result = CountCoins.count(input);
        int expected = 1;
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_2_when_count_given_5() {
        //given
        int input = 5;
        //when
        int result = CountCoins.count(input);
        int expected = 2;
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_2_when_count_given_7() {
        //given
        int input = 7;
        //when
        int result = CountCoins.count(input);
        int expected = 2;
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_4_when_count_given_10() {
        //given
        int input = 10;
        //when
        int result = CountCoins.count(input);
        int expected = 4;
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_4_when_count_given_13() {
        //given
        int input = 13;
        //when
        int result = CountCoins.count(input);
        int expected = 4;
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_6_when_count_given_15() {
        //given
        int input = 15;
        //when
        int result = CountCoins.count(input);
        int expected = 6;
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_9_when_count_given_20() {
        //given
        int input = 20;
        //when
        int result = CountCoins.count(input);
        int expected = 9;
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_13_when_count_given_25() {
        //given
        int input = 25;
        //when
        int result = CountCoins.count(input);
        int expected = 13;
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_18_when_count_given_30() {
        //given
        int input = 30;
        //when
        int result = CountCoins.count(input);
        int expected = 18;
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_24_when_count_given_35() {
        //given
        int input = 35;
        //when
        int result = CountCoins.count(input);
        int expected = 24;
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void printResult_given_100() {
        System.out.println(CountCoins.count(100));
    }

    @Test
    public void result_test() {
        List<Integer> numbers = Arrays.asList(1, 5, 7, 10, 15, 17, 20, 25, 30, 33, 35, 40);
        for (Integer integer : numbers) {
            int count = 0;
            for (int a = 0; a <= 50; a++) {
                for (int b = 0; b <= 50; b++) {
                    for (int c = 0; c <= 50; c++) {
                        for (int d = 0; d <= 50; d++) {
                            if (a + b * 5 + c * 10 + d * 25 == integer) {
                                count++;
                            }
                        }
                    }
                }
            }
//            System.out.println("number=" + integer + ":=" + count);
        }
    }
}
