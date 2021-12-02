package net.alphakun.plugin.autodifficultychanger.events

import net.alphakun.plugin.autodifficultychanger.AutoDifficultyChanger
import net.alphakun.plugin.autodifficultychanger.AutoDifficultyChanger.Companion.PLAYERS
import net.alphakun.plugin.autodifficultychanger.AutoDifficultyChanger.Companion.onlinePlayers
import net.alphakun.plugin.autodifficultychanger.ChangeDifficultyUtil
import org.bukkit.Difficulty
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

class PlayerQuit : Listener {

    @EventHandler
    fun playerQuit(e: PlayerQuitEvent) {
        onlinePlayers.forEach{
            for (p in PLAYERS) {
                if (p == it.name) return
            }
        }
        for (w in AutoDifficultyChanger.WORLDS) {
            ChangeDifficultyUtil.changeDiff(w, Difficulty.PEACEFUL)
        }
    }
}