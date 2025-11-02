/*
Copyright 2008-present Shaiksphere, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.shaiksphere.mindsmine.jems;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * A collection of useful static methods to deal with URLs.
 *
 * @see java.net.URI
 *
 * @author Mohammed Shaik Hussain Ali
 *
 * @since 3.5.0
 *
 */
public final class URLHelper {

    private URLHelper() {}

    /**
     * Returns <code>true</code> if the passed string is a valid URL, <code>false</code> otherwise.
     * <br><br>
     * Example Usage:
     *
     * <pre>
     *     URLHelper.isValidURL("http://userid@example.com")       //  true
     *     URLHelper.isValidURL("www.example.com/main.html")       //  false
     * </pre>
     *
     * @param url to check
     *
     * @return if the string is a valid URL
     *
     * @since 3.5.0
     *
     */
    public static boolean isValidURL(String url) {
        if (StringHelper.getNullSafe(url).isBlank()) {
            return false;
        }

        try {
            var _url = new URI(url);
        } catch (URISyntaxException e) {
            return false;
        }

        return true;
    }

    /**
     * Appends content to the query string of a URL, handling logic for whether to place a question mark or ampersand.
     *
     * @param url The URL to append to.
     * @param param The parameter key to append to the URL.
     * @param value The parameter value to append to the URL.
     *
     * @return The resulting URL
     *
     * @throws IllegalArgumentException for Invalid URL or empty arguments
     *
     * @since 3.5.0
     *
     */
    public static String appendQuery(String url, String param, Object value) {
        if (!isValidURL(url)) {
            throw new IllegalArgumentException("Fatal Error. 'url'. Invalid URL.");
        }

        if (StringHelper.getNullSafe(param).isBlank()) {
            throw new IllegalArgumentException("Fatal Error. 'param'. Only non-empty string(s) are allowed as arguments.");
        }

        URI _uri = null;

        try {
            _uri = new URI(url);
        } catch (URISyntaxException e) {
            // do nothing
        }

        var query = _uri.getRawQuery();

        if (StringHelper.getNullSafe(query).isBlank()) {
            query = param + '=' + value;
        } else {
            query += '&' + param + '=' + value;
        }

        URI _finalURI = null;

        try {
            _finalURI = new URI(_uri.getScheme(), _uri.getRawUserInfo(), _uri.getHost(), _uri.getPort(), _uri.getRawPath(), query, _uri.getRawFragment());
        } catch (URISyntaxException e) {
            // do nothing
        }

        return _finalURI.toString();
    }
}
