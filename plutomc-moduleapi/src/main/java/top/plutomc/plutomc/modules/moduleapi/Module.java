package top.plutomc.plutomc.modules.moduleapi;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;
import java.util.Set;

/**
 * @packageName: top.plutomc.plutomc
 * @className: Module
 * @author: GerryYuu
 * @date: 7/25/2022 5:19 PM
 */

public abstract class Module {
    private static Set<Module> modules = new HashSet<>();
    private static JavaPlugin pluginInstance = null;

    public static void registerModule(Module module) {
        modules.add(module);
    }

    public static Set<Module> getModules() {
        return modules;
    }

    public JavaPlugin getPluginInstance() {
        return pluginInstance;
    }

    public static void setPluginInstance(JavaPlugin pluginInstance) {
        Module.pluginInstance = pluginInstance;
    }

    public abstract void reload();

    public abstract void init();
}
