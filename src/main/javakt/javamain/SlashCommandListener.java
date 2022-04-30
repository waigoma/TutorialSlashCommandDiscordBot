package javamain;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class SlashCommandListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        // test コマンドなら処理をする。
        if (event.getName().equals("test")) {
            // コマンド送信者に対して、その人にだけ見えるメッセージとして返信する。
            event.reply("This is test command!").setEphemeral(true).queue();
        }
    }
}
