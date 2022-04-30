package ktmain

import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent

import javax.security.auth.login.LoginException

class MainKt {
    companion object {
        private const val TOKEN = "Discord bot のトークンを記述"
    }

    fun first() {
        try {
            //Login
            JDABuilder.createLight(TOKEN, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                .addEventListeners()
                .setActivity(Activity.playing("作業")) // "～をプレイ中" の ～の部分
                .build()
        } catch (e: LoginException) {
            e.printStackTrace()
        }
    }
}

fun main(){
    MainKt().first()
}