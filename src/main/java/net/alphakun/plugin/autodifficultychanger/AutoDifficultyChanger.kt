package net.alphakun.plugin.autodifficultychanger

import net.alphakun.plugin.autodifficultychanger.events.PlayerJoin
import net.alphakun.plugin.autodifficultychanger.events.PlayerQuit
import org.bukkit.Bukkit
import org.bukkit.Difficulty
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class AutoDifficultyChanger : JavaPlugin() {

    override fun onEnable() {
        saveDefaultConfig()
        loadConfig()
        generateEvents()
    }

    override fun onDisable() {
        ChangeDifficultyUtil.changeDiff(Difficulty.PEACEFUL)
    }

    fun loadConfig() {
        WORLDS = config.getStringList("worlds")
        PLAYERS = config.getStringList("players")
    }

    fun generateEvents() {
        server.pluginManager.registerEvents(PlayerJoin(), this)
        server.pluginManager.registerEvents(PlayerQuit(), this)
    }

    companion object {
        var WORLDS: MutableList<String> = mutableListOf()
        var PLAYERS: MutableList<String> = mutableListOf()
    }
}