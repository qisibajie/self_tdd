package cyber.dojo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FizzBuzzTest {

    @Test
    public void should_return_1_when_decide_given_1() {
        //given
        int input = 1;
        //when
        String result = FizzBuzz.decide(input);
        //then
        String expected = "1";
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_Fizz_when_decide_given_3() {
        //given
        int input = 3;
        //when
        String result = FizzBuzz.decide(input);
        //then
        String expected = "Fizz";
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_Fizz_when_decide_given_9() {
        //given
        int input = 9;
        //when
        String result = FizzBuzz.decide(input);
        //then
        String expected = "Fizz";
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_Buzz_when_decide_given_5() {
        //given
        int input = 5;
        //when
        String result = FizzBuzz.decide(input);
        //then
        String expected = "Buzz";
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_Buzz_when_decide_given_10() {
        //given
        int input = 10;
        //when
        String result = FizzBuzz.decide(input);
        //then
        String expected = "Buzz";
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_FizzBuzz_when_decide_given_15() {
        //given
        int input = 15;
        //when
        String result = FizzBuzz.decide(input);
        //then
        String expected = "FizzBuzz";
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_FizzBuzz_when_decide_given_30() {
        //given
        int input = 30;
        //when
        String result = FizzBuzz.decide(input);
        //then
        String expected = "FizzBuzz";
        assertThat(result, is(expected));
    }
}
