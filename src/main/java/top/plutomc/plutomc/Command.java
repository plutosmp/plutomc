package top.plutomc.plutomc;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import top.plutomc.plutomc.modules.moduleapi.Module;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName: top.plutomc.plutomc
 * @className: Command
 * @author: GerryYuu
 * @date: 7/26/2022 1:37 PM
 */

public class Command implements TabExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) sender.sendMessage(MiniMessage.miniMessage().deserialize("<red>You have to input args."));

        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            PlutoMC.instance().reloadConfig();;
            Module.getModules().forEach(Module::reload);
            sender.sendMessage(MiniMessage.miniMessage().deserialize("<green>Reload completed."));
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1) list.add("reload");
        return list;
    }
}
