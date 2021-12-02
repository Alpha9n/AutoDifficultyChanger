package net.alphakun.plugin.autodifficultychanger

import net.alphakun.plugin.autodifficultychanger.AutoDifficultyChanger.Companion.WORLDS
import org.bukkit.Bukkit
import org.bukkit.Difficulty
import org.bukkit.entity.Player

object ChangeDifficultyUtil {

    fun changeDiff(difficulty: Difficulty, mPlayer: MutableList<Player> = mutableListOf(Bukkit.getPlayer("Alpha9n")!!) ) {
        WORLDS.forEach {
            Bukkit.getWorld(it)!!.difficulty = difficulty
        }
        mPlayer.forEach{
            it.sendMessage("§f[§aADC§f]:" + "難易度を§6${difficulty.name}§fに変更しました")
        }
    }
}