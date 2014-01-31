/*
 * Copyright (C) 2013 Rei Ichimaru (市丸 零) <jms21maru@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ta.app.util;

/**
 *
 * @author Rei Ichimaru (市丸 零) <jms21maru@gmail.com>
 */
public class Randomize {

    public static String randomLowerCase(int length) {
        String random = "";

        for (int at = 0; at < length; at++) {
            random += random('a', 'z');
        }

        return random;
    }

    public static String randomUpperCase(int length) {
        String random = "";

        for (int at = 0; at < length; at++) {
            random += random('A', 'Z');
        }

        return random;
    }

    public static String randomDigit(int length) {
        String random = "";

        for (int at = 0; at < length; at++) {
            random += random('0', '9');
        }

        return random;
    }

    public static String randomCharacter(int length) {
        String random = "";

        for (int at = 0; at < length; at++) {
            random += random('\u0000', '\uFFFF');
        }

        return random;
    }

    private static char random(char first, char last) {
        return (char) (first + Math.random() * (last - first + 1));
    }
}
