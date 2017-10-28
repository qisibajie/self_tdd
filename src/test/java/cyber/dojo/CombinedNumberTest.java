package cyber.dojo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CombinedNumberTest {
    @Test
    public void should_return_itself_when_combine_given_one_number() {
        //given
        List<Integer> numbers = Arrays.asList(0);
        String expected = "0";
        //when
        String result = CombinedNumber.combine(numbers);
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_itself_when_combine_given_multiple_0() {
        //given
        List<Integer> numbers = Arrays.asList(0, 0, 0, 0, 0, 0);
        String expected = "000000";
        //when
        String result = CombinedNumber.combine(numbers);
        //then
        assertThat(result, is(expected));
    }


    @Test
    public void should_return_itself_when_combine_given_multiple_0_10() {
        //given
        List<Integer> numbers = Arrays.asList(0, 0, 0, 0, 0, 0, 10);
        String expected = "10000000";
        //when
        String result = CombinedNumber.combine(numbers);
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_120_when_combine_given_12_0() {
        //given
        List<Integer> numbers = Arrays.asList(12, 0);
        String expected = "120";
        //when
        String result = CombinedNumber.combine(numbers);
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_110_when_combine_given_10_1() {
        //given
        List<Integer> numbers = Arrays.asList(10, 1);
        String expected = "110";
        //when
        String result = CombinedNumber.combine(numbers);
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_110_when_combine_given_1_10() {
        //given
        List<Integer> numbers = Arrays.asList(1, 10);
        String expected = "110";
        //when
        String result = CombinedNumber.combine(numbers);
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_1312_when_combine_given_12_13() {
        //given
        List<Integer> numbers = Arrays.asList(12, 13);
        String expected = "1312";
        //when
        String result = CombinedNumber.combine(numbers);
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_56550_when_given_5_50_56() {
        //given
        List<Integer> numbers = Arrays.asList(5, 50, 56);
        String expected = "56550";
        //when
        String result = CombinedNumber.combine(numbers);
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_95021_when_given_50_2_1_9() {
        //given
        List<Integer> numbers = Arrays.asList(50, 2, 1, 9);
        String expected = "95021";
        //when
        String result = CombinedNumber.combine(numbers);
        //then
        assertThat(result, is(expected));
    }

    @Test
    public void should_return_42423420_when_given_420_42_423() {
        //given
        List<Integer> numbers = Arrays.asList(420, 42, 423);
        String expected = "42423420";
        //when
        String result = CombinedNumber.combine(numbers);
        //then
        assertThat(result, is(expected));
    }
}
