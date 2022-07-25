package top.plutomc.plutomc.modules.joinquitmsg;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import top.plutomc.plutomc.moduleapi.Module;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @packageName: top.plutomc.plutomc.modules.joinquitmsg
 * @className: JQModule
 * @author: GerryYuu
 * @date: 7/25/2022 6:03 PM
 */

public final class JQModule extends Module {
    private static File configFile;
    private static FileConfiguration configuration;

    public JQModule() {
        super("joinquitmsg");
    }

    public static FileConfiguration getConfiguration() {
        return configuration;
    }

    public static File getConfigFile() {
        return configFile;
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {
        configFile = new File(getPluginInstance().getDataFolder(), "jqmsg.yml");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
                configuration = YamlConfiguration.loadConfiguration(configFile);
                configuration.set("joinMsg", "<gray>[<green>+<gray>] <white>~player~ <gray>加入了游戏。");
                configuration.set("quitMsg", "<gray>[<red>-<gray>] <white>~player~ <gray>退出了游戏。");
                configuration.set("joinServerMsg", List.of("<gray>你好！"));
                configuration.save(configFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void onDisable() {

    }
}