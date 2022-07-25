package top.plutomc.plutomc.moduleapi;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @packageName: top.plutomc.plutomc
 * @className: Module
 * @author: GerryYuu
 * @date: 7/25/2022 5:19 PM
 */

public abstract class Module {
    private final String name;

    private static JavaPlugin pluginInstance = null;

    public Module(String name) {
        this.name = name;
    }

    public abstract void onLoad();

    public abstract void onEnable();

    public abstract void onDisable();

    public String getName() {
        return name;
    }

    public JavaPlugin getPluginInstance() {
        return pluginInstance;
    }

    public static void setPluginInstance(JavaPlugin pluginInstance) {
        Module.pluginInstance = pluginInstance;
    }
}
