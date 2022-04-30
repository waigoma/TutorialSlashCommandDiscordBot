package ktmain

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class SlashCommandListener : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        // test コマンドなら処理をする。
        if (event.name == "test") {
            // コマンド送信者に対して、その人にだけ見えるメッセージとして返信する。
            event.reply("This is test command!").setEphemeral(true).queue()
        }
    }
}