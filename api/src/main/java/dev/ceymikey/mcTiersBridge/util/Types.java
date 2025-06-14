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
package dev.ceymikey.mcTiersBridge.util;

import com.google.gson.JsonObject;

/**
 * Types class for the McTierBridge API.
 * Registering these types in TypeRegistry.
 */
public abstract class Types {
    public static Types VANILLA = new Types() {
        @Override
        public Object getTier(JsonObject jsonObject) {
            JsonObject rankings = jsonObject.getAsJsonObject("rankings");
            JsonObject vanilla = rankings.getAsJsonObject("vanilla");
            return vanilla.get("tier").getAsInt();
        }
    };
    public static Types SWORD = new Types() {
        @Override
        public Object getTier(JsonObject jsonObject) {
            JsonObject rankings = jsonObject.getAsJsonObject("rankings");
            JsonObject economy = rankings.getAsJsonObject("sword");
            return economy.get("tier").getAsInt();
        }
    };
    public static Types POT = new Types() {
        @Override
        public Object getTier(JsonObject jsonObject) {
            JsonObject rankings = jsonObject.getAsJsonObject("rankings");
            JsonObject economy = rankings.getAsJsonObject("pot");
            return economy.get("tier").getAsInt();
        }
    };
    public static Types UHC = new Types() {
        @Override
        public Object getTier(JsonObject jsonObject) {
            JsonObject rankings = jsonObject.getAsJsonObject("rankings");
            JsonObject economy = rankings.getAsJsonObject("uhc");
            return economy.get("tier").getAsInt();
        }
    };
    public static Types SMP = new Types() {
        @Override
        public Object getTier(JsonObject jsonObject) {
            JsonObject rankings = jsonObject.getAsJsonObject("rankings");
            JsonObject economy = rankings.getAsJsonObject("smp");
            return economy.get("tier").getAsInt();
        }
    };
    public static Types NETHOP = new Types() {
        @Override
        public Object getTier(JsonObject jsonObject) {
            JsonObject rankings = jsonObject.getAsJsonObject("rankings");
            JsonObject economy = rankings.getAsJsonObject("nethop");
            return economy.get("tier").getAsInt();
        }
    };
    public static Types OVERALL = new Types() {
        @Override
        public Object getTier(JsonObject jsonObject) {
            return jsonObject.get("overall").getAsInt();
        }
    };
    public static Types REGION = new Types() {
        @Override
        public Object getTier(JsonObject jsonObject) {
            return jsonObject.get("region").getAsString();
        }
    };
    public static Types POINTS = new Types() {
        @Override
        public Object getTier(JsonObject jsonObject) {
            return jsonObject.get("points").getAsInt();
        }
    };
    /**
     * Factory method to create a position type for a specific game mode
     * @param gameMode The game mode to get position for (vanilla, sword, pot, uhc, smp)
     * @return A Types instance that gets position for the specified game mode
     */
    public static Types getPositionForMode(String gameMode) {
        return new Types() {
            @Override
            public Object getTier(JsonObject jsonObject) {
                JsonObject rankings = jsonObject.getAsJsonObject("rankings");
                JsonObject modeData = rankings.getAsJsonObject(gameMode);
                int pos = modeData.get("pos").getAsInt();
                switch (pos) {
                    case 0:
                        return "ht";
                    case 1:
                        return "lt";
                    default:
                        return "Unknown tier";
                }
            }
        };
    }

    /**
     * Legacy position type that defaults to vanilla
     * @deprecated Use getPositionForMode("vanilla") instead
     */
    @Deprecated
    public static Types POSITION = new Types() {
        @Override
        public Object getTier(JsonObject jsonObject) {
            JsonObject rankings = jsonObject.getAsJsonObject("rankings");
            JsonObject vanilla = rankings.getAsJsonObject("vanilla");
            int pos = vanilla.get("pos").getAsInt();
            switch (pos) {
                case 0:
                    return "ht";
                case 1:
                    return "lt";
                default:
                    return "Unknown tier";
            }
        }
    };

    /**
     * Forces getTier method to be implemented in all values.
     * @param jsonObject  JsonObject containing the tier data
     * @return            Returns tier value
     */
    public abstract Object getTier(JsonObject jsonObject);
}
