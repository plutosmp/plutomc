package top.plutomc.plutomc;

import org.bukkit.plugin.java.JavaPlugin;
import top.plutomc.plutomc.moduleapi.Module;
import top.plutomc.plutomc.modules.joinquitmsg.JQModule;

import java.util.HashSet;
import java.util.Set;

public final class PlutoMC extends JavaPlugin {

    private static JavaPlugin instance;

    public static JavaPlugin instance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        Module.setPluginInstance(instance());
        if (!getDataFolder().exists()) getDataFolder().mkdirs();
        new JQModule();
    }

    @Override
    public void onDisable() {
    }
}