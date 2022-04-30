package javamain;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {
    private static final String TOKEN = "Discord bot のトークンを記述";

    public static void main(String[] args) {
        try {
            //Login
            JDABuilder.createLight(TOKEN, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                    .addEventListeners()
                    .setActivity(Activity.playing("作業")) // "～をプレイ中" の ～の部分
                    .build();
        }catch (LoginException e){
            e.printStackTrace();
        }
    }
}
