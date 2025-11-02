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

import org.junit.Test;

import org.junit.function.ThrowingRunnable;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class URLHelperTest {

    @Test
    public void isValidURLPassTest() {
        Arrays.asList(
                "https://api.iextrading.com",
                "https://api.iextrading.com/1.0/stock/market/batch",
                "https://api.iextrading.com/1.0/stock/market/batch?types=quote",
                "https://api.iextrading.com/1.0/stock/market/batch?types=quote&symbols=AAPL",
                "https://api.iextrading.com/1.0/stock/market/batch?types=quote&symbols=AAPL#",
                "https://api.iextrading.com/1.0/stock/market/batch?types=quote&symbols=AAPL#tab1",
                "http://userid:password@example.com:8080",
                "http://userid:password@example.com:8080/",
                "http://userid@example.com",
                "http://userid@example.com/",
                "http://userid@example.com:8080",
                "http://userid@example.com:8080/",
                "http://userid:password@example.com",
                "http://userid:password@example.com/",
                "http://142.42.1.1/",
                "http://142.42.1.1:8080/",
                "http://➡.ws/䨹",
                "http://⌘.ws",
                "http://foo.com/blah_(wikipedia)#cite-1",
                "http://foo.com/blah_(wikipedia)_blah#cite-1",
                "http://foo.com/unicode_(✪)_in_parens",
                "http://foo.com/(something)?after=parens",
                "http://☺.damowmow.com/",
                "http://code.google.com/events/#&product=browser",
                "http://j.mp",
                "ftp://foo.bar/baz",
                "http://foo.bar/?q=Test%20URL-encoded%20stuff",
                "http://例子.测试"
        ).forEach(url -> assertTrue(URLHelper.isValidURL(url)));
    }

    @Test
    public void isValidURLFailTest() {
        Arrays.asList(
                null,
                "",
                "//",
                "http://⌘.ws/	",
                "http://مثال.إختبار	",
                ":// should fail"
        ).forEach(url -> assertFalse(URLHelper.isValidURL(url)));
    }

    @Test
    public void appendQueryInvalidURLExceptionTest() {
        assertThrows(
                "Fatal Error. 'url'. Invalid URL.",
                IllegalArgumentException.class,
                new ThrowingRunnable() {
                    @Override
                    public void run() throws Throwable {
                        URLHelper.appendQuery(null, null, null);
                    }
                }
        );

        assertThrows(
                "Fatal Error. 'url'. Invalid URL.",
                IllegalArgumentException.class,
                new ThrowingRunnable() {
                    @Override
                    public void run() throws Throwable {
                        URLHelper.appendQuery(":// should fail", null, null);
                    }
                }
        );
    }

    @Test
    public void appendQueryInvalidParamExceptionTest() {
        assertThrows(
                "Fatal Error. 'param'. Only non-empty string(s) are allowed as arguments.",
                IllegalArgumentException.class,
                new ThrowingRunnable() {
                    @Override
                    public void run() throws Throwable {
                        URLHelper.appendQuery("http://www.google.com", null, null);
                    }
                }
        );
    }

    @Test
    public void appendQueryTest() {
        final String url = "http://www.google.com",
                urlQ = url + "?param1=value1",
                urlH = url + "#hash1",
                urlQH = url + "?param1=value1#hash1",
                param2 = "param2",
                value2 = "value2";

        assertEquals("http://www.google.com?param2=value2", URLHelper.appendQuery(url, param2, value2));
        assertEquals("http://www.google.com?param1=value1&param2=value2", URLHelper.appendQuery(urlQ, param2, value2));
        assertEquals("http://www.google.com?param2=value2#hash1", URLHelper.appendQuery(urlH, param2, value2));
        assertEquals("http://www.google.com?param1=value1&param2=value2#hash1", URLHelper.appendQuery(urlQH, param2, value2));
    }
}
