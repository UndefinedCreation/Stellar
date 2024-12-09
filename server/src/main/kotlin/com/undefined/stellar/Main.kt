package com.undefined.stellar

import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    override fun onEnable() {
        StellarCommand("test")
            .addLocationArgument("location")
            .addWolfVariantArgument("test")
            .addExecution<Player> {
                sender.sendMessage(arguments.toList().withIndex().joinToString(", ") { "${it.index}: ${it.value.first}" })
            }
            .register(this)
    }

}