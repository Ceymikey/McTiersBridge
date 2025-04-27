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
package dev.ceymikey.mcTiersBridge.placeholders.holders;

import dev.ceymikey.mcTiersBridge.placeholders.Holder;
import dev.ceymikey.mcTiersBridge.placeholders.Placeholder;
import dev.ceymikey.mcTiersBridge.util.MessageUtil;
import dev.ceymikey.mcTiersBridge.util.TierBridge;
import dev.ceymikey.mcTiersBridge.util.Types;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

@Placeholder(
        name = "pot"
)
public class PPot extends Holder {
    @Override
    public String process(OfflinePlayer player, String[] args) {
        TierBridge bridge = new TierBridge();
        if (args.length == 1) {
            try {
                Object tier = bridge.getData(String.valueOf(player.getName()), Types.POT);
                Object pos = bridge.getData(String.valueOf(player.getName()), Types.POSITION);
                return pos + "" + tier;
            } catch (Exception e) {
                return MessageUtil.get().NOT_FOUND;
            }
        }
        Player targetPlayer = Bukkit.getPlayerExact(args[1]);
        if (targetPlayer != null) {
            try {
                Object tier = bridge.getData(args[1], Types.POT);
                Object pos = bridge.getData(args[1], Types.POSITION);
                return pos + "" + tier;
            } catch (Exception e) {
                return MessageUtil.get().NOT_FOUND;
            }
        }
        return null;
    }
}
