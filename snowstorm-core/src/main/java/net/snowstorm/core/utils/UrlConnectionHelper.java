package net.snowstorm.core.utils;

import net.snowstorm.core.url.UrlConnectionReader;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA. User: developer Date: 4/17/12 Time: 9:37 PM To change this template use File | Settings |
 * File Templates.
 */
public class UrlConnectionHelper {

    private static final Logger LOG = LoggerFactory.getLogger(UrlConnectionHelper.class);

    private UrlConnectionReader urlConnectionReader;

    public UrlConnectionReader getUrlConnectionReader() {
        return urlConnectionReader;
    }

    public byte[] urlPayloadToByteArray(String url) {
        urlConnectionReader = new UrlConnectionReader();
        InputStream inputStream = null;
        try {
            inputStream = urlConnectionReader.fetch(new URL(url));
            byte[] bytes =  IOUtils.toByteArray(inputStream);
            inputStream.close();
            return bytes;
        } catch (MalformedURLException e) {
            LOG.error("Malformed URL: ", e);
        } catch (IOException e) {
            LOG.error("Failed to read or close InputStream", e);
        }
        return null;
    }
}
