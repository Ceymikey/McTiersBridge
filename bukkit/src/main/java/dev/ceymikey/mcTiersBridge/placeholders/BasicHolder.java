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
package dev.ceymikey.mcTiersBridge.placeholders;

import dev.ceymikey.mcTiersBridge.McTiersBridge;
import dev.ceymikey.mcTiersBridge.placeholders.holders.*;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class BasicHolder extends PlaceholderExpansion {
    private final ArrayList<Holder> subHolder = new ArrayList<>();

    public BasicHolder() {
        subHolder.add(new PVanilla());
        subHolder.add(new PSword());
        subHolder.add(new PPot());
        subHolder.add(new PUhc());
        subHolder.add(new PSmp());
        subHolder.add(new PNethOp());
        subHolder.add(new POverall());
        subHolder.add(new PPoints());
        subHolder.add(new PRegion());
    }

    @Override
    public @NotNull String getIdentifier() {
        return "TierBridge";
    }

    @Override
    public @NotNull String getAuthor() {
        return McTiersBridge.getAUTHOR();
    }

    @Override
    public @NotNull String getVersion() {
        return McTiersBridge.getVERSION();
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        int index = params.indexOf('_');
        if (index == -1) {
            return null;
        }

        String placeholderType = params.substring(0, index);
        String username = params.substring(index + 1);

        for (Holder holder : subHolder) {
            if (placeholderType.equalsIgnoreCase(holder.getName())) {
                return holder.process(player, new String[]{placeholderType, username});
            }
        }
        return null;
    }

}