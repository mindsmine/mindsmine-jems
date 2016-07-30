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

/**
 * A collection of useful static methods to deal with strings.
 *
 * @see java.lang.String
 *
 * @author Mohammed Shaik Hussain Ali
 *
 * @since 1.0
 *
 */
public final class StringHelper {

    private StringHelper() {}

    /**
     * Returns a non-null string, even if the object being passed is a null string.
     *
     * If the passed-in object is a non-null string, then it is returned as-is.
     *
     * Example usage:
     *
     * <pre>
     *      String str1 = "Hello";
     *      String str2 = null;
     *
     *      String str3 = StringHelper.getNullSafe(str1);
     *
     *      String str4 = StringHelper.getNullSafe(str2);
     *
     *      // str3 now contains the string: "Hello"
     *      // str4 now contains the string: ""
     * </pre>
     *
     * @param string The string to safeguard against <code>null</code>.
     *
     * @return If str is <code>null</code> then <code>""</code> (empty string).
     *
     * @since 1.0
     *
     */
    public static String getNullSafe(String string) {
        return (string == null) ? "" : string;
    }

    /**
     * Returns <code>true</code> if the passed value is an empty string, false otherwise.
     * <br><br>
     * The value is deemed to be an empty string if it is either:
     * <ul>
     *     <li><code>null</code></li>
     *     <li>a zero-length string</li>
     *     <li>comprised of whitespaces as defined by {@link java.lang.Character#isWhitespace(char)}</li>
     * </ul>
     *
     * <pre>
     *     StringHelper.isBlank(null)          = true
     *     StringHelper.isBlank("")            = true
     *     StringHelper.isBlank(" ")           = true
     *     StringHelper.isBlank("something ")  = false
     * </pre>
     *
     * @param string The value to test.
     *
     * @return <code>true</code> if the passed value is an empty string, false otherwise.
     *
     * @since 1.0
     *
     */
    public static boolean isBlank(String string) {
        int strLen;

        if (string == null || (strLen = string.length()) == 0) {
            return true;
        }

        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(string.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns <code>true</code> if the passed values are equal, ignoring the case, false
     * otherwise.
     * <br><br>
     * Two strings are considered equal if,
     * <ul>
     *     <li>Both strings are blank, as defined by {@link StringHelper#isBlank(String)}.</li>
     *     <li>Trimmed versions of both strings, as defined by {@link String#trim()}, are equal.</li>
     * </ul>
     *
     * <pre>
     *     StringHelper.areEqual(null, null)      = true
     *     StringHelper.areEqual(null, "")        = true
     *     StringHelper.areEqual("", "")          = true
     *     StringHelper.areEqual("   ", "")       = true
     *     StringHelper.areEqual(" abc", "abc ")  = true
     *     StringHelper.areEqual("", "abc")       = false
     *     StringHelper.areEqual("ab c", "abc")   = false
     *     StringHelper.areEqual("ABC", "abc")    = true
     * </pre>
     *
     * @see java.lang.String#equalsIgnoreCase(String)
     *
     * @param string1 to compare
     * @param string2 to compare
     *
     * @return whether two strings are equal
     *
     * @since 1.0
     *
     */
    public static boolean areEqual(String string1, String string2) {
        return  isBlank(string1) &&
                isBlank(string2) ||
                !(isBlank(string1) || isBlank(string2)) &&
                        string1.trim().equalsIgnoreCase(string2.trim());
    }

    /**
     * Returns <code>true</code> if the passed string contains only digits, false otherwise.
     *
     * <pre>
     *     StringHelper.isOnlyDigits(null)          = false
     *     StringHelper.isOnlyDigits("")            = false
     *     StringHelper.isOnlyDigits(" ")           = false
     *     StringHelper.isOnlyDigits("something ")  = false
     *     StringHelper.isOnlyDigits("11.67")       = false
     *     StringHelper.isOnlyDigits("17650")       = true
     * </pre>
     *
     * @see java.lang.String#matches(String)
     *
     * @param string to check
     *
     * @return whether the string contains only digits
     *
     * @since 1.0
     *
     */
    public static boolean isOnlyDigits(String string) {
        return (!isBlank(string) && string.matches("\\d+"));
    }
}