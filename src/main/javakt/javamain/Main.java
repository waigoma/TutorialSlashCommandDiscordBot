package javamain;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {
    private static final String TOKEN = "Discord bot のトークンを記述";
    private static final String GUILD_ID = "Discord サーバーの ID を記述";

    public static void main(String[] args) {
        try {
            // Login 処理
            JDA jda = JDABuilder.createLight(TOKEN, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                    .addEventListeners()
                    .setActivity(Activity.playing("作業")) // "～をプレイ中" の ～の部分
                    .build();

            // ログインが完了するまで待つ
            jda.awaitReady();

            // 参加しているサーバーを ID から取得
            Guild guild = jda.getGuildById(GUILD_ID);

            // 登録するコマンドを作成
            SlashCommandData testCommand = Commands.slash("test", "テストコマンド");

            // コマンドを指定したサーバーに登録
            guild.updateCommands()
                    .addCommands(testCommand)
                    .queue();

        }catch (LoginException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
