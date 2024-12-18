package com.undefined.stellar.data.execution

import com.undefined.stellar.data.argument.CommandContext
import org.bukkit.command.CommandSender
import kotlin.reflect.KClass
import kotlin.reflect.safeCast

@Suppress("UNCHECKED_CAST")
data class StellarRunnable<C : CommandSender>(val clazz: KClass<C>, val execution: CommandContext<C>.() -> Boolean) {
    operator fun invoke(context: CommandContext<CommandSender>): Boolean {
        if (clazz.safeCast(context.sender) == null) return true
        return execution(context as? CommandContext<C> ?: return true)
    }
}