package net.snowstorm.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA. User: developer Date: 2/18/12 Time: 6:54 PM To change this template use File | Settings |
 * File Templates.
 */
public class StringHelper {
    private static final Logger LOG = LoggerFactory.getLogger(StringHelper.class);

    public static String capitalize(String uncapitalized){
        if (uncapitalized.length() > 0){
            return uncapitalized.toString().substring(0, 1).toUpperCase() + uncapitalized.toString().substring(1).toLowerCase();
        }
        return null;
    }

    public static String urlEncodeString(String unencodedString){
        StringBuilder resultStr = new StringBuilder();
        for (char ch : unencodedString.toCharArray()) {
            if (isUnsafe(ch)) {
                resultStr.append('%');
                resultStr.append(toHex(ch / 16));
                resultStr.append(toHex(ch % 16));
            } else {
                resultStr.append(ch);
            }
        }
        return resultStr.toString();
    }

    private static char toHex(int ch) {
        return (char) (ch < 10 ? '0' + ch : 'A' + ch - 10);
    }

    private static boolean isUnsafe(char ch) {
        if (ch > 128 || ch < 0)
            return true;
        return " %$&+,/:;=?@<>#%".indexOf(ch) >= 0;
    }
}
