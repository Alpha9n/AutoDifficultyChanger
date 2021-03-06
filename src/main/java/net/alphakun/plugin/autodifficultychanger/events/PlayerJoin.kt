package net.alphakun.plugin.autodifficultychanger.events

import net.alphakun.plugin.autodifficultychanger.AutoDifficultyChanger.Companion.PLAYERS
import net.alphakun.plugin.autodifficultychanger.AutoDifficultyChanger.Companion.WORLDS
import net.alphakun.plugin.autodifficultychanger.ChangeDifficultyUtil
import org.bukkit.Bukkit
import org.bukkit.Difficulty
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoin: Listener {

    @EventHandler
    fun playerJoin(e: PlayerJoinEvent) {
        val onlinePlayers = Bukkit.getOnlinePlayers() as MutableList<Player>
        for (p in PLAYERS) {
            if (e.player.name == p) {
                ChangeDifficultyUtil.changeDiff(Difficulty.EASY, onlinePlayers)
                return
            }
        }
    }
}