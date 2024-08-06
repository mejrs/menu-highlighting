package com.menuhighlighting;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.MenuEntry;
import net.runelite.client.util.Text;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class Pattern {
    String option;
    String target;

    private Pattern(String option, String target) {
        this.option = option;
        this.target = target;
    }

    public static Pattern fromString(String input) {
        String[] x = input.split(",", 2);
        if (x.length == 2) {
            // like "attack, man"
            return new Pattern(x[0].trim(), x[1].trim());
        } else {
            // Or just "man"
            return new Pattern(null, x[0].trim());
        }
    }

    public static boolean match_wildcard(String pattern, String taggedInput) {
        // "*" and "**" will match any input
        if (pattern.equals("*") || pattern.equals("**")) {
            return true;
        }
        String input = Text.removeTags(taggedInput);
        boolean atStart = pattern.startsWith("*");
        boolean atEnd = pattern.endsWith("*");

        if (atStart && atEnd) { // such as "*abc*"
            return StringUtils.containsIgnoreCase(input, pattern.subSequence(1, pattern.length() - 1));
        } else if (atStart) { // such as "*abc"
            return StringUtils.endsWithIgnoreCase(input, pattern.subSequence(1, pattern.length()));
        } else if (atEnd) { // such as "abc*"
            return StringUtils.startsWithIgnoreCase(input, pattern.subSequence(0, pattern.length() - 1));
        } else { // No wildcards, just compare it
            return pattern.equalsIgnoreCase(input);
        }
    }

    public boolean matches(MenuEntry entry) {
        return this.match_option(entry.getOption()) && this.match_target(entry.getTarget());
    }

    private boolean match_option(String option) {
        if (this.option == null) {
            return true;
        }
        return Pattern.match_wildcard(this.option, option);
    }

    private boolean match_target(String target) {
        return Pattern.match_wildcard(this.target, target);
    }

}