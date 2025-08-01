/*
 * This file is part of McTiersBridge, https://github.com/Ceymikey/McTiersBridge
 *
 * Copyright (c) 2024-2025 Ceymikeydev and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package dev.ceymikey.mcTiersBridge;

import dev.ceymikey.mcTiersBridge.metrics.Metrics;
import dev.ceymikey.mcTiersBridge.placeholders.BasicHolder;
import dev.ceymikey.mcTiersBridge.util.TierBridge;
import dev.ceymikey.mcTiersBridge.util.TypeRegistry;
import dev.ceymikey.mcTiersBridge.util.Types;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class McTiersBridge extends JavaPlugin implements Listener {
    @Getter private static final String AUTHOR = "Ceymikey";
    @Getter private static final String VERSION = "1.0.2";
    @Getter private static McTiersBridge instance;
    private static final int pluginId = 23667;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Registering hooks and managers..");
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getPluginManager().registerEvents(this, this);
        } else {
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        getLogger().info("Registering types and API...");
        registerTypes();
        /* Here we safely register the API. */
        McTiersBridgeAPI.setInstance(new TierBridge());

        /* I love metrics :D */
        Metrics metrics = new Metrics(this, pluginId);

        /* Here we safely register the PAPI placeholder. */
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new BasicHolder().register();
        }
    }

    public void registerTypes() {
        TypeRegistry.register("vanilla", Types.VANILLA);
        TypeRegistry.register("sword", Types.SWORD);
        TypeRegistry.register("pot", Types.POT);
        TypeRegistry.register("uhc", Types.UHC);
        TypeRegistry.register("smp", Types.SMP);
        TypeRegistry.register("nethop", Types.NETHOP);
        TypeRegistry.register("overall", Types.OVERALL);
        TypeRegistry.register("position", Types.POSITION);
        TypeRegistry.register("points", Types.POINTS);
        TypeRegistry.register("region", Types.REGION);
    }

    public static McTiersBridge i() {
        if (instance == null) {
            instance = new McTiersBridge();
        }
        return instance;
    }
}
