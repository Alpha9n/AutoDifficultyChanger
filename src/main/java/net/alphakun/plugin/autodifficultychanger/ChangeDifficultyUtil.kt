package net.alphakun.plugin.autodifficultychanger

import org.bukkit.Bukkit
import org.bukkit.Difficulty

object ChangeDifficultyUtil {

    fun changeDiff(world: String, difficulty: Difficulty) {
        Bukkit.getWorld(world)!!.difficulty = difficulty
    }
}