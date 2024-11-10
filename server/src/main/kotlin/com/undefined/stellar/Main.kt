package com.undefined.stellar

import com.undefined.stellar.data.ParticleData
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import java.util.UUID

class Main : JavaPlugin() {

    val players: HashMap<UUID, ParticleData<*>> = hashMapOf()

    override fun onEnable() {
        StellarCommand("test")
            .addOperationSubCommand("operation")
            .addObjectiveExecution<Player> {
                sendMessage(it.apply(1, 2).toString())
            }
            .register()
    }

}