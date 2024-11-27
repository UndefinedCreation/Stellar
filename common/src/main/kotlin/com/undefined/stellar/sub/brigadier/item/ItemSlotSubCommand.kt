package com.undefined.stellar.sub.brigadier.item

import com.undefined.stellar.AbstractStellarCommand
import com.undefined.stellar.data.execution.CustomStellarExecution
import com.undefined.stellar.data.execution.CustomStellarRunnable
import com.undefined.stellar.sub.BaseStellarSubCommand
import org.bukkit.command.CommandSender

@Suppress("UNCHECKED_CAST")
class ItemSlotSubCommand(parent: AbstractStellarCommand<*>, name: String) : BaseStellarSubCommand<ItemSlotSubCommand>(parent, name) {
    inline fun <reified T : CommandSender> addItemSlotExecution(noinline execution: T.(Int) -> Unit): ItemSlotSubCommand {
        customExecutions.add(CustomStellarExecution(T::class, execution) as CustomStellarExecution<*, Any?>)
        return this
    }

    inline fun <reified T : CommandSender> alwaysRunItemSlot(noinline execution: T.(Int) -> Boolean): ItemSlotSubCommand {
        customRunnables.add(CustomStellarRunnable(T::class, execution) as CustomStellarRunnable<*, Any?>)
        return this
    }
}