package dev.ceymikey.mcTiersBridge.util;

import org.bukkit.ChatColor;

public class MessageUtil {
    private static MessageUtil instance;
    public String SUCCESS = translateCode("&aSuccessfully processed the request.");
    public String NOT_FOUND = "N/A";
    public String ERROR = translateCode("&cAn error occurred while processing the request.");
    public String ERROR(Exception e) { return translateCode("&cAn error occurred while processing the request: " + e.getMessage()); }

    private String translateCode(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static MessageUtil get() {
        if (instance == null) {
            instance = new MessageUtil();
        }
        return instance;
    }
}
