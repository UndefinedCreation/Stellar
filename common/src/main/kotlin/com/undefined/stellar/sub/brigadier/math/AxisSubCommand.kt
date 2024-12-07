package com.undefined.stellar.sub.brigadier.math

import com.undefined.stellar.AbstractStellarCommand
import com.undefined.stellar.data.execution.CustomStellarExecution
import com.undefined.stellar.data.execution.CustomStellarRunnable
import com.undefined.stellar.sub.BaseStellarSubCommand
import org.bukkit.Axis
import org.bukkit.command.CommandSender
import java.util.EnumSet

@Suppress("UNCHECKED_CAST")
class AxisSubCommand(parent: AbstractStellarCommand<*>, name: String) : BaseStellarSubCommand<AxisSubCommand>(parent, name) {
    inline fun <reified T : CommandSender> addAxisExecution(noinline execution: T.(EnumSet<Axis>) -> Unit): AxisSubCommand {
        customExecutions.add(CustomStellarExecution(T::class, execution) as CustomStellarExecution<*, Any?>)
        return this
    }

    inline fun <reified T : CommandSender> alwaysRunAxis(noinline execution: T.(EnumSet<Axis>) -> Boolean): AxisSubCommand {
        customRunnables.add(CustomStellarRunnable(T::class, execution) as CustomStellarRunnable<*, Any?>)
        return this
    }
}