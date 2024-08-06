package com.menuhighlighting;

import net.runelite.api.MenuEntry;

import java.util.ArrayList;
import java.util.List;

public class Highlight {
    private List<Pattern> patterns;

    public static Highlight fromString(String input) {
        Highlight slf = new Highlight();
        ArrayList<Pattern> patterns = new ArrayList<>();
        if (input != null) {
            for (String line : input.split("\n")) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                patterns.add(Pattern.fromString(line));
            }
        }
        slf.patterns = patterns;
        return slf;
    }

    public boolean contains(MenuEntry entry) {
        if (entry.getPlayer() != null) {
            // So that you can't do (for example) `attack, *rot*`
            // to violate the `Indicates players in an opposing clan in PVP` rule.
            return false;
        }
        for (Pattern pattern : patterns) {
            if (pattern.matches(entry)) {
                return true;
            }
        }
        return false;
    }

}