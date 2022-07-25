package top.plutomc.plutomc.modules.joinquitmsg;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import top.plutomc.plutomc.moduleapi.MessageUtil;

/**
 * @packageName: top.plutomc.plutomc.modules.joinquitmsg
 * @className: PlayerListeners
 * @author: GerryYuu
 * @date: 7/25/2022 6:07 PM
 */

public final class PlayerListeners implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.joinMessage(MessageUtil.parseMsg(JQModule.getConfiguration().getString("joinMsg")));
        JQModule.getConfiguration().getStringList("joinServerMsg")
                .forEach(message -> event.getPlayer().sendMessage(MessageUtil.parseMsg(message)));
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.quitMessage(MessageUtil.parseMsg(JQModule.getConfiguration().getString("quitMsg")));
    }
}
