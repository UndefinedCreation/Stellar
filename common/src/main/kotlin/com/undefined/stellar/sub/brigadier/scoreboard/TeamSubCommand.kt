package com.undefined.stellar.sub.brigadier.scoreboard

import com.undefined.stellar.AbstractStellarCommand
import com.undefined.stellar.data.execution.CustomStellarExecution
import com.undefined.stellar.data.execution.CustomStellarRunnable
import com.undefined.stellar.sub.BaseStellarSubCommand
import org.bukkit.command.CommandSender
import org.bukkit.scoreboard.Team

@Suppress("UNCHECKED_CAST")
class TeamSubCommand(parent: AbstractStellarCommand<*>, name: String) : BaseStellarSubCommand<TeamSubCommand>(parent, name) {
    inline fun <reified T : CommandSender> addTeamExecution(noinline execution: T.(Team) -> Unit): TeamSubCommand {
        customExecutions.add(CustomStellarExecution(T::class, execution) as CustomStellarExecution<*, Any?>)
        return this
    }

    inline fun <reified T : CommandSender> alwaysRunTeam(noinline execution: T.(Team) -> Boolean): TeamSubCommand {
        customRunnables.add(CustomStellarRunnable(T::class, execution) as CustomStellarRunnable<*, Any?>)
        return this
    }
}