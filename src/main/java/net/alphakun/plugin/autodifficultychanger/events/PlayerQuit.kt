package net.alphakun.plugin.autodifficultychanger.events

import net.alphakun.plugin.autodifficultychanger.AutoDifficultyChanger
import net.alphakun.plugin.autodifficultychanger.AutoDifficultyChanger.Companion.PLAYERS
import net.alphakun.plugin.autodifficultychanger.ChangeDifficultyUtil
import org.bukkit.Bukkit
import org.bukkit.Difficulty
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

class PlayerQuit : Listener {

    @EventHandler
    fun playerQuit(e: PlayerQuitEvent) {
        val onlinePlayers = Bukkit.getOnlinePlayers() as MutableList<Player>
        onlinePlayers.forEach{
            for (p in PLAYERS) {
                if (p == it.name && e.player.name != p) return
                break
            }
        }
        ChangeDifficultyUtil.changeDiff(Difficulty.PEACEFUL, onlinePlayers)
    }
}