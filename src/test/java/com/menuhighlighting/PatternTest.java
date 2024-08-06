package com.menuhighlighting;

import org.junit.Test;

public class PatternTest {
    @Test public void pattern() {
        PatternTest.matches("*ar", "bar") ;
        PatternTest.matches("*bar", "bar") ;
        PatternTest.matches("ba*", "bar");
        PatternTest.matches("**", "anything");
        PatternTest.matches("*", "just a wildcard");
        PatternTest.matches("foo", "foo") ;
    }

    private static void matches(String pattern, String input) throws AssertionError{
        assert Pattern.match_wildcard(pattern, input): String.format("'%s' should match '%s'", pattern, input);
    }

    @Test public void incorrectPattern() {
        PatternTest.matchesNot("foo", "bar") ;
        PatternTest.matchesNot("ba", "bar");
        PatternTest.matchesNot("xz*", "xyz");
    }

    private static void matchesNot(String pattern, String input) throws AssertionError {
        assert !Pattern.match_wildcard(pattern, input): String.format("'%s' should not match '%s'", pattern, input);
    }

}
