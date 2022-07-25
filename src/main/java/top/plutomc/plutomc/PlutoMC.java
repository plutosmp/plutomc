package top.plutomc.plutomc;

import org.bukkit.plugin.java.JavaPlugin;
import top.plutomc.plutomc.moduleapi.Module;
import top.plutomc.plutomc.modules.joinquitmsg.JQModule;

import java.util.HashSet;
import java.util.Set;

public final class PlutoMC extends JavaPlugin {

    private static JavaPlugin instance;

    private static Set<Module> modules;

    public static JavaPlugin instance() {
        return instance;
    }

    public static Set<Module> getModules() {
        return modules;
    }

    public static void registerModule(Module module) {
        modules.add(module);
    }

    @Override
    public void onLoad() {
        modules = new HashSet<>();
        registerModule(new JQModule());
        modules.forEach(module -> onLoad());
    }

    @Override
    public void onEnable() {
        instance = this;
        Module.setPluginInstance(instance());
        modules.forEach(module -> onEnable());
    }

    @Override
    public void onDisable() {
        modules.forEach(module -> onDisable());
    }
}