package com.undefined.stellar.manager

import com.undefined.stellar.listener.StellarListener
import com.undefined.stellar.registrar.AbstractCommandRegistrar
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.jetbrains.annotations.ApiStatus

@ApiStatus.Internal
object CommandManager {
    val registrars: Map<String, AbstractCommandRegistrar> = mapOf(
        "1.20.6" to com.undefined.stellar.v1_20_6.CommandRegistrar,
        "1.21.3" to com.undefined.stellar.v1_21_3.CommandRegistrar,
    )

    val initializedPlugins: MutableList<JavaPlugin> = mutableListOf()
    fun initialize(plugin: JavaPlugin) {
        if (initializedPlugins.contains(plugin)) return
        initializedPlugins.add(plugin)
        Bukkit.getPluginManager().registerEvents(StellarListener, plugin)
    }
}