package cyber.dojo;

import org.junit.Test;

import org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class AnagramsTest {
    @Test
    public void should_return_empty_when_calculate_anagrams_given_empty() {
        //given
        //when
        List<String> anagrams = Anagrams.of("");
        //then
        assertThat(anagrams, is(Arrays.asList("")));
    }

    @Test
    public void should_return_itself_when_calculate_anagrams_given_a_letter() {
        //given
        //when
        List<String> anagrams = Anagrams.of("a");
        //then
        assertThat(anagrams, is(Arrays.asList("a")));
    }

    @Test
    public void should_return_size_2_when_calculate_anagrams_given_two_letters() {
        //given
        //when
        List<String> anagrams = Anagrams.of("ab");
        //then
        assertThat(anagrams, is(Arrays.asList("ab", "ba")));
    }

    @Test
    public void should_return_size_6_when_calculate_anagrams_given_Three_letters() {
        //given
        //when
        List<String> anagrams = Anagrams.of("abc");
        //then
        assertThat(anagrams, is(Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba")));
    }

    @Test
    public void should_return_size_24_when_calculate_anagrams_given_four_letters() {
        //given
        //when
        List<String> anagrams = Anagrams.of("abcd");
        //Then
        assertThat(anagrams.size(), is(24));
    }

    @Test
    public void should_return_size_120_when_calculate_anagrams_given_five_letters() {
        //given
        //when
        List<String> anagrams = Anagrams.of("abcde");
        //then
        assertThat(anagrams.size(), is(120));
    }
}
