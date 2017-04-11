/* Copyright 2017 Andrew Dawson
 *
 * This file is part of Tusky.
 *
 * Tusky is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * Tusky is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with Tusky. If
 * not, see <http://www.gnu.org/licenses/>. */

package com.keylesspalace.tusky;

/**A wrapper for android.util.Log that allows for disabling logging, such as for release builds.*/
public class Log {
    private static final boolean LOGGING_ENABLED = BuildConfig.DEBUG;
    private static String longBoy;
    private static String watchedTag;

    public static void i(String tag, String string) {
        if (LOGGING_ENABLED) {
            android.util.Log.i(tag, string);
            if (tag.equals(watchedTag)) {
                longBoy += string + '\n';
            }
        }
    }

    public static void e(String tag, String string) {
        if (LOGGING_ENABLED) {
            android.util.Log.e(tag, string);
        }
    }

    public static void d(String tag, String string) {
        if (LOGGING_ENABLED) {
            android.util.Log.d(tag, string);
        }
    }

    public static void v(String tag, String string) {
        if (LOGGING_ENABLED) {
            android.util.Log.v(tag, string);
        }
    }

    public static void w(String tag, String string) {
        if (LOGGING_ENABLED) {
            android.util.Log.w(tag, string);
        }
    }

    static void watchTag(String tag) {
        longBoy = "";
        watchedTag = tag;
    }

    static String getWatchedMessages() {
        watchedTag = null;
        return longBoy;
    }
}