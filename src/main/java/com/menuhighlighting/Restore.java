package com.menuhighlighting;

import net.runelite.api.MenuEntry;

public class Restore {
    private final MenuEntry entry;
    private final String oldTarget;
    private final String oldOption;

    public Restore(MenuEntry entry, String oldTarget, String oldOption) {
        this.entry = entry;
        this.oldTarget = oldTarget;
        this.oldOption = oldOption;
    }

    public void restore() {
        entry.setTarget(oldTarget);
        entry.setOption(oldOption);
    }
}