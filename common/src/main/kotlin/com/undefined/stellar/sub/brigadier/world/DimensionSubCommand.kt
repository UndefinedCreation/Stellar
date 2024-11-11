package com.undefined.stellar.sub.brigadier.world

import com.undefined.stellar.BaseStellarCommand
import com.undefined.stellar.data.execution.CustomStellarExecution
import com.undefined.stellar.data.execution.CustomStellarRunnable
import com.undefined.stellar.sub.brigadier.BrigadierTypeSubCommand
import org.bukkit.World.Environment
import org.bukkit.command.CommandSender

@Suppress("UNCHECKED_CAST")
class DimensionSubCommand(parent: BaseStellarCommand<*>, name: String) : BrigadierTypeSubCommand<DimensionSubCommand>(parent, name) {
    inline fun <reified T : CommandSender> addDimensionExecution(noinline execution: T.(Environment) -> Unit): DimensionSubCommand {
        customExecutions.add(CustomStellarExecution(T::class, execution) as CustomStellarExecution<*, Any>)
        return this
    }

    inline fun <reified T : CommandSender> alwaysRunDimension(noinline execution: T.(Environment) -> Boolean): DimensionSubCommand {
        customRunnables.add(CustomStellarRunnable(T::class, execution) as CustomStellarRunnable<*, Any>)
        return this
    }
}