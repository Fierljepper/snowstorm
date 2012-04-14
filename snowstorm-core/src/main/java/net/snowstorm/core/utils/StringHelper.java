package net.snowstorm.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
        try {
            if (unencodedString != null){
                return URLEncoder.encode(unencodedString, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            LOG.error("Character encoding is set to UTF-8, this exception should not be thrown.",
                    e);
        }
        return null;
    }
}
