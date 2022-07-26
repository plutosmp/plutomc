package top.plutomc.plutomc;

import org.bukkit.plugin.java.JavaPlugin;
import top.plutomc.plutomc.modules.joinquitmsg.JQModule;
import top.plutomc.plutomc.modules.moduleapi.Module;

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
        Module.registerModule(new JQModule());
        Module.getModules().forEach(Module::init);
        getServer().getPluginCommand("plutomc").setExecutor(new Command());
        getServer().getPluginCommand("plutomc").setTabCompleter(new Command());
    }

    @Override
    public void onDisable() {
    }
}