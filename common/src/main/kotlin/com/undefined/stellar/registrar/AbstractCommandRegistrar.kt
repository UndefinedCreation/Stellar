package com.undefined.stellar.registrar

import com.undefined.stellar.AbstractStellarCommand
import org.bukkit.command.CommandSender

interface AbstractCommandRegistrar {
    fun register(command: AbstractStellarCommand<*>)
    fun handleCommandFailure(sender: CommandSender, input: String): Boolean
}