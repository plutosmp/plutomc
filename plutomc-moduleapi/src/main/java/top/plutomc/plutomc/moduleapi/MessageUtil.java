package top.plutomc.plutomc.moduleapi;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.ChatColor;

/**
 * @packageName: top.plutomc.plutomc.moduleapi
 * @className: MessageUtils
 * @author: GerryYuu
 * @date: 7/25/2022 9:35 PM
 */

public final class MessageUtil {
    private MessageUtil() {
    }

    public static Component parseMsg(String m) {
        MiniMessage miniMessage = MiniMessage.miniMessage();
        return miniMessage.deserialize(ChatColor.translateAlternateColorCodes('&', m));
    }
}
