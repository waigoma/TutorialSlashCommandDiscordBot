package ktmain

import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.requests.GatewayIntent

import javax.security.auth.login.LoginException

class MainKt {
    companion object {
        private const val TOKEN = "Discord bot のトークンを記述"
        private const val GUILD_ID = "Discord サーバーの ID を記述"
    }

    fun first() {
        try {
            // Login 処理
            val jda = JDABuilder.createLight(TOKEN, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                .addEventListeners(SlashCommandListener())
                .setActivity(Activity.playing("作業")) // "～をプレイ中" の ～の部分
                .build()

            // ログインが完了するまで待つ
            jda.awaitReady()

            // 参加しているサーバーを ID から取得
            val guild = jda.getGuildById(GUILD_ID)!!

            // 登録するコマンドを作成
            val testCommand = Commands.slash("test", "テストコマンド")

            // 指定したサーバーにコマンドを登録
            guild.updateCommands()
                .addCommands(testCommand)
                .queue()

        } catch (e: LoginException) {
            e.printStackTrace()
        }
    }
}

fun main(){
    MainKt().first()
}