package com.menuhighlighting;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuOpened;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.config.Keybind;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.input.KeyListener;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ColorUtil;
import net.runelite.client.util.Text;

import javax.inject.Inject;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

@Slf4j
@PluginDescriptor(name = "Menu Highlighting")
public class MenuHighlighting extends Plugin implements KeyListener {
    private final ArrayList<Keybind> keybinds = new ArrayList<>();
    private final ArrayList<Highlight> highlights = new ArrayList<>();
    private final ArrayList<Restore> restores = new ArrayList<>();
    @Inject
    private Client client;
    @Inject
    private KeyManager keyManager;
    @Inject
    private MenuHighlightingConfig config;
    @Inject
    private ConfigManager configManager;
    private Integer activeKey = null;

    @Override
    protected void startUp() throws Exception {
        reload();
        keyManager.registerKeyListener(this);
    }

    @Override
    protected void shutDown() throws Exception {
        keyManager.unregisterKeyListener(this);
        restores.clear();
    }

    @Provides
    MenuHighlightingConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(MenuHighlightingConfig.class);
    }

    private void reload() {
        keybinds.clear();
        highlights.clear();
        for (int i = 0; i < 20; i++) {
            keybinds.add(configManager.getConfiguration("menuhighlights", "hotkey" + (i + 1), Keybind.class));
            highlights.add(Highlight.fromString(
                    configManager.getConfiguration("menuhighlights", "hotkey" + (i + 1) + "Field", String.class)));
        }
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged configChanged) {
        if (configChanged.getGroup().equals("menuhighlights")) {
            reload();
        }
    }

    private void recolour(Highlight highlight, MenuEntry[] menuEntries) {
        if (menuEntries != null) {
            for (MenuEntry entry : menuEntries) {
                String rawTarget = entry.getTarget();
                String target = Text.removeTags(rawTarget);
                String option = entry.getOption();

                if (highlight.contains(entry)) {
                    String newTarget = ColorUtil.prependColorTag(target, config.highlightedColor());
                    entry.setTarget(newTarget);
                } else {
                    entry.setTarget(ColorUtil.prependColorTag(target, config.unHighlightedColor()));
                    String newOption = Text.removeTags(option);
                    entry.setOption(ColorUtil.prependColorTag(newOption, config.unHighlightedColor()));
                }
                restores.add(new Restore(entry, rawTarget, option));
            }
        }
    }

    @Subscribe(priority = -1)
    public void onMenuOpened(MenuOpened event) {
        restores.clear();

        if (activeKey == null) {
            return;
        }
        int index = -1;
        for (int i = 0; i < keybinds.size(); i++) {
            int key = keybinds.get(i).getKeyCode();
            if (activeKey.equals(key)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            // Should never happen...
            return;
        }
        Highlight highlight = highlights.get(index);
        recolour(highlight, event.getMenuEntries());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        int index = -1;
        for (int i = 0; i < keybinds.size(); i++) {
            Keybind key = keybinds.get(i);
            if (key.matches(e)) {
                index = i;
                break;
            }
        }
        if (index == -1 || activeKey != null) {
            return;
        }

        activeKey = code;
        Highlight highlight = highlights.get(index);
        if (client.isMenuOpen()) {
            recolour(highlight, client.getMenuEntries());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (activeKey != null && activeKey.equals(e.getKeyCode())) {
            for (Restore restore : restores) {
                restore.restore();
            }
            restores.clear();
            activeKey = null;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
