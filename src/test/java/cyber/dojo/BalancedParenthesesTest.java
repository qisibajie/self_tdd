package cyber.dojo;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BalancedParenthesesTest {
    @Test
    public void should_return_true_when_decide_balance_given_empty_String() {
        //given
        String input = "";
        //when
        boolean result = BalancedParentheses.isBalanced(input);
        //then
        assertThat(result, is(true));
    }

    @Test
    public void should_return_false_when_decide_balance_given_a_letter() {
        //given
        String input = "{";
        //when
        boolean result = BalancedParentheses.isBalanced(input);
        //then
        assertThat(result, is(false));
    }

    @Test
    public void should_return_false_when_decide_balance_given_two_letters_1() {
        //given
        String input = "{)";
        //when
        boolean result = BalancedParentheses.isBalanced(input);
        //Then
        assertThat(result, is(false));
    }

    @Test
    public void should_return_false_when_decide_balance_given_two_letters_2() {
        //given
        String input = "[}";
        //when
        boolean result = BalancedParentheses.isBalanced(input);
        //then
        assertThat(result, is(false));
    }

    @Test
    public void should_return_true_when_decide_balance_given_two_letters_3() {
        //given
        String input = "()";
        //when
        boolean result = BalancedParentheses.isBalanced(input);
        //then
        assertThat(result, is(true));
    }

    @Test
    public void should_return_true_when_decide_balance_given_two_letters_4() {
        //given
        String input = "[]";
        //when
        boolean result = BalancedParentheses.isBalanced(input);
        //then
        assertThat(result, is(true));
    }

    @Test
    public void should_return_true_when_decide_balance_given_two_letters_5() {
        //given
        String input = "{}";
        //when
        boolean result = BalancedParentheses.isBalanced(input);
        //then
        assertThat(result, is(true));
    }

    @Test
    public void should_return_false_when_decide_balance_given_three_letters() {
        //given
        String input = "()}";
        //when
        boolean result = BalancedParentheses.isBalanced(input);
        //then
        assertThat(result, is(false));
    }

    @Test
    public void should_return_true_when_decide_balance_given_four_letters() {
        //given
        String input = "{()}";
        //when
        boolean result = BalancedParentheses.isBalanced(input);
        //then
        assertThat(result, is(true));
    }

    @Test
    public void should_return_true_when_decide_balance_given_six_letters_1() {
        //given
        String input = "{}([])";
        //when
        boolean result = BalancedParentheses.isBalanced(input);
        //then
        assertThat(result, is(true));
    }

    @Test
    public void should_return_false_when_decide_balance_given_six_letters() {
        //given
        String input = "{{)(}}";
        //when
        boolean result = BalancedParentheses.isBalanced(input);
        //then
        assertThat(result, is(false));
    }

    @Test
    public void should_return_true_when_decide_balance_given_ten_letters() {
        //given
        String input = "{()}[[{}]]";
        //when
        boolean result = BalancedParentheses.isBalanced(input);
        //then
        assertThat(result, is(true));
    }

}
