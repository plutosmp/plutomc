package top.plutomc.plutomc;

import org.bukkit.plugin.java.JavaPlugin;
import top.plutomc.plutomc.moduleapi.Module;

import java.util.HashSet;
import java.util.Set;

public final class PlutoMC extends JavaPlugin {

    private static JavaPlugin instance;

    private static Set<Module> modules;

    public static JavaPlugin instance() {
        return instance;
    }

    @Override
    public void onLoad() {
        modules = new HashSet<>();
        modules.forEach(Module::onLoad);
    }

    @Override
    public void onEnable() {
        instance = this;
        modules.forEach(Module::onEnable);
    }

    @Override
    public void onDisable() {
        modules.forEach(Module::onDisable);
    }

    public static Set<Module> getModules() {
        return modules;
    }

    public static void registerModule(Module module) {
        modules.add(module);
    }
}