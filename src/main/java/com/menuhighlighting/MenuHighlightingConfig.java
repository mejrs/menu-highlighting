package com.menuhighlighting;

import net.runelite.client.config.*;

import java.awt.*;

@ConfigGroup("menuhighlights")
public interface MenuHighlightingConfig extends Config {

    @Alpha
    @ConfigItem(keyName = "highlightedColor", name = "Highlighted color", description = "Configures the color for highlighted items", position = 0)
    default Color highlightedColor() {
        return Color.PINK;
    }

    @Alpha
    @ConfigItem(keyName = "unHighlightedColor", name = "Unhighlighted color", description = "Configures the color for not highlighted items", position = 1)
    default Color unHighlightedColor() {
        return new Color(128, 128, 128, 128);
    }

    @ConfigSection(name = "Hotkeys", description = "Hotkey-based highlighting.", position = 2, closedByDefault = false)
    String hotkeys = "hotkeys";

    @ConfigItem(keyName = "hotkey1", name = "hotkey 1", description = "", section = hotkeys, position = 3)
    default Keybind hotkey1() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey1Field", name = "", description = "", section = hotkeys, position = 4)
    default String hotkey1Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey2", name = "hotkey 2", description = "", section = hotkeys, position = 5)
    default Keybind hotkey2() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey2Field", name = "", description = "", section = hotkeys, position = 6)
    default String hotkey2Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey3", name = "hotkey 3", description = "", section = hotkeys, position = 7)
    default Keybind hotkey3() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey3Field", name = "", description = "", section = hotkeys, position = 8)
    default String hotkey3Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey4", name = "hotkey 4", description = "", section = hotkeys, position = 9)
    default Keybind hotkey4() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey4Field", name = "", description = "", section = hotkeys, position = 10)
    default String hotkey4Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey5", name = "hotkey 5", description = "", section = hotkeys, position = 11)
    default Keybind hotkey5() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey5Field", name = "", description = "", section = hotkeys, position = 12)
    default String hotkey5Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey6", name = "hotkey 6", description = "", section = hotkeys, position = 13)
    default Keybind hotkey6() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey6Field", name = "", description = "", section = hotkeys, position = 14)
    default String hotkey6Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey7", name = "hotkey 7", description = "", section = hotkeys, position = 15)
    default Keybind hotkey7() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey7Field", name = "", description = "", section = hotkeys, position = 16)
    default String hotkey7Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey8", name = "hotkey 8", description = "", section = hotkeys, position = 17)
    default Keybind hotkey8() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey8Field", name = "", description = "", section = hotkeys, position = 18)
    default String hotkey8Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey9", name = "hotkey 9", description = "", section = hotkeys, position = 19)
    default Keybind hotkey9() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey9Field", name = "", description = "", section = hotkeys, position = 20)
    default String hotkey9Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey10", name = "hotkey 10", description = "", section = hotkeys, position = 21)
    default Keybind hotkey10() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey10Field", name = "", description = "", section = hotkeys, position = 22)
    default String hotkey10Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey11", name = "hotkey 11", description = "", section = hotkeys, position = 23)
    default Keybind hotkey11() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey11Field", name = "", description = "", section = hotkeys, position = 24)
    default String hotkey11Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey12", name = "hotkey 12", description = "", section = hotkeys, position = 25)
    default Keybind hotkey12() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey12Field", name = "", description = "", section = hotkeys, position = 26)
    default String hotkey12Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey13", name = "hotkey 13", description = "", section = hotkeys, position = 27)
    default Keybind hotkey13() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey13Field", name = "", description = "", section = hotkeys, position = 28)
    default String hotkey13Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey14", name = "hotkey 14", description = "", section = hotkeys, position = 29)
    default Keybind hotkey14() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey14Field", name = "", description = "", section = hotkeys, position = 30)
    default String hotkey14Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey15", name = "hotkey 15", description = "", section = hotkeys, position = 31)
    default Keybind hotkey15() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey15Field", name = "", description = "", section = hotkeys, position = 32)
    default String hotkey15Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey16", name = "hotkey 16", description = "", section = hotkeys, position = 33)
    default Keybind hotkey16() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey16Field", name = "", description = "", section = hotkeys, position = 34)
    default String hotkey16Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey17", name = "hotkey 17", description = "", section = hotkeys, position = 35)
    default Keybind hotkey17() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey17Field", name = "", description = "", section = hotkeys, position = 36)
    default String hotkey17Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey18", name = "hotkey 18", description = "", section = hotkeys, position = 37)
    default Keybind hotkey18() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey18Field", name = "", description = "", section = hotkeys, position = 38)
    default String hotkey18Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey19", name = "hotkey 19", description = "", section = hotkeys, position = 39)
    default Keybind hotkey19() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey19Field", name = "", description = "", section = hotkeys, position = 40)
    default String hotkey19Field() {
        return "";
    }

    @ConfigItem(keyName = "hotkey20", name = "hotkey 20", description = "", section = hotkeys, position = 41)
    default Keybind hotkey20() {
        return Keybind.NOT_SET;
    }

    @ConfigItem(keyName = "hotkey20Field", name = "", description = "", section = hotkeys, position = 42)
    default String hotkey20Field() {
        return "";
    }
}
