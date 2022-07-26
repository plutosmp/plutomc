package top.plutomc.plutomc.modules.joinquitmsg;

import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @packageName: top.plutomc.plutomc.modules.joinquitmsg
 * @className: PlayerListeners
 * @author: GerryYuu
 * @date: 7/25/2022 6:07 PM
 */

public final class PlayerListeners implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.joinMessage(MiniMessage.miniMessage().deserialize(
                JQModule.getConfiguration().getString("joinMsg"),
                Placeholder.parsed("player", event.getPlayer().getName())
        ));
        JQModule.getConfiguration().getStringList("joinServerMsg").forEach(
                msg -> event.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize(msg,
                        Placeholder.parsed("player", event.getPlayer().getName())))
        );
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.quitMessage(MiniMessage.miniMessage().deserialize(
                JQModule.getConfiguration().getString("quitMsg"),
                Placeholder.parsed("player", event.getPlayer().getName())
        ));
    }
}