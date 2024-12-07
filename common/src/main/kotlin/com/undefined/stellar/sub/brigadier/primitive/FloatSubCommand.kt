package com.undefined.stellar.sub.brigadier.primitive

import com.undefined.stellar.AbstractStellarCommand
import com.undefined.stellar.data.execution.CustomStellarExecution
import com.undefined.stellar.data.execution.CustomStellarRunnable
import com.undefined.stellar.sub.BaseStellarSubCommand
import org.bukkit.command.CommandSender

@Suppress("UNCHECKED_CAST")
class FloatSubCommand(parent: AbstractStellarCommand<*>, name: String, val min: Float, val max: Float) : BaseStellarSubCommand<FloatSubCommand>(parent, name) {
    inline fun <reified T : CommandSender> addFloatExecution(noinline execution: T.(Float) -> Unit): FloatSubCommand {
        customExecutions.add(CustomStellarExecution(T::class, execution) as CustomStellarExecution<*, Any?>)
        return this
    }

    inline fun <reified T : CommandSender> alwaysRunFloat(noinline execution: T.(Float) -> Boolean): FloatSubCommand {
        customRunnables.add(CustomStellarRunnable(T::class, execution) as CustomStellarRunnable<*, Any?>)
        return this
    }
}
