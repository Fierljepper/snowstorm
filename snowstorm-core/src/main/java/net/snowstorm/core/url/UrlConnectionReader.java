package net.snowstorm.core.url;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.zip.GZIPInputStream;

/**
 * <p>
 * The Class <b>URLConnectionReader</b> is built around a single method for
 * connecting to a specified URL and retrieving it's contents.
 * </p>
 */
public class UrlConnectionReader implements Serializable {

    private UUID uuid = UUID.fromString("0ec1e73b-c015-4c41-b6ed-7161bc73598c");

    private static final Logger LOG = LoggerFactory.getLogger(UrlConnectionReader.class);

    private static final int INTERNAL_SERVER_ERROR = 500;

    private static final int SERVICE_UNAVAILABLE = 503;

    private static final int PAGE_NOT_FOUND = 404;

    private static final long TIMEOUT = 3000l;

    private static final int SECOND_IN_MILISECONDS = 1000;

    private static final int RECONNECT_ATTEMPTS = 10;

    public static final String GZIP_CONTENT_ENCODING= "gzip";

    private int reconnectAttempts = RECONNECT_ATTEMPTS;

    private int responseCode;

    private String contentTypeHeader;

    private String contentEncodingHeader;

    private int contentLengthHeader;
    
    private boolean proxy;
    
    private String proxyHost;
    
    private String proxyPort;

    private transient HttpURLConnection connection;

    private Map<String, List<String>> responseProperties;

    private Map<String, String> requestProperties;

    {
        requestProperties = new HashMap<String, String>();
        requestProperties.put("Accept","application/json");
        requestProperties.put("Accept-Charset", "utf-8");
//        requestProperties.put("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_8) AppleWebKit/535.7 (KHTML, like Gecko) Chrome/16.0.912.77 Safari/535.7");
        requestProperties.put("Accept-Encoding", "gzip");
    }

    
    public final int getResponseCode() {
        return this.responseCode;
    }

    public final String getContentTypeHeader() {
        return this.contentTypeHeader;
    }

    public final String getContentEncodingHeader() {
        return this.contentEncodingHeader;
    }

    public final int getContentLengthHeader() {
        return this.contentLengthHeader;
    }

    public boolean isProxy() {
        return proxy;
    }

    // FIXME make a proxy object containing host, port and identification
    public void setProxy(boolean proxy) {
        this.proxy = proxy;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public void setProxyHost(String proxyHost) {
        this.proxyHost = proxyHost;
    }

    public String getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(String proxyPort) {
        this.proxyPort = proxyPort;
    }

    public void disconnect(){
        this.connection.disconnect();
    }

    public Map<String, List<String>> getResponseProperties() {
        return responseProperties;
    }

    public void setRequestPropertie(final String requestPropertie, final String requestValue) {
        this.requestProperties.put(requestPropertie, requestValue);
    }

    public java.util.Map<String, String> getRequestProperties() {
        return requestProperties;
    }

    public final InputStream fetch(final URL url) {
        try {
            final Properties systemProperties = System.getProperties();
            if (isProxy()) {
                systemProperties.setProperty("http.proxyHost", getProxyHost());
                systemProperties.setProperty("http.proxyPort", getProxyPort());
            }

            connection = (HttpURLConnection) url.openConnection();
            for (Map.Entry<String, String> header : requestProperties.entrySet()){
                connection.setRequestProperty(header.getKey(), header.getValue());
            }
            /*
            * Set class properties
            */
            this.responseCode = connection.getResponseCode();
            this.contentTypeHeader = connection.getContentType();
            this.contentEncodingHeader = connection.getContentEncoding();
            this.contentLengthHeader = connection.getContentLength();
            this.responseProperties = connection.getHeaderFields();
//            if (((this.responseCode == INTERNAL_SERVER_ERROR) || (this.responseCode == SERVICE_UNAVAILABLE))
//                    && (this.reconnectAttempts > 0)) {
//                this.reconnectAttempts--;
//                LOG.info("Server returned response code: " + this.responseCode
//                        + ". " + "Going to wait "
//                        + (TIMEOUT / SECOND_IN_MILISECONDS)
//                        + " seconds  before atempting to reconnect. "
//                        + "Attempts remaining: " + this.reconnectAttempts
//                        + "\n");
//                Thread.sleep(TIMEOUT);
//
//                return fetch(url);
//            } else {
                this.reconnectAttempts = RECONNECT_ATTEMPTS;
                connection.connect();
                LOG.info("Fetching InputStream from URL: " + url.toString());
                if (GZIP_CONTENT_ENCODING.equals(getContentEncodingHeader())){
                    return new GZIPInputStream(getConnectionInputStream(connection));
                }
                return getConnectionInputStream(connection);
//            }

        }
//        catch (final InterruptedException e) {
//            LOG.error("Current thread was interupted.", e);
//        }
        catch (final IOException e) {
            LOG.error("Could not open url: " + url.toString(), e);
        }

        return null;
    }


    private InputStream getConnectionInputStream(HttpURLConnection httpUrlConnection) throws IOException {
        if (PAGE_NOT_FOUND == this.getResponseCode() || INTERNAL_SERVER_ERROR == this.getResponseCode()){
            return httpUrlConnection.getErrorStream();
        }

        return httpUrlConnection.getInputStream();
    }

}
