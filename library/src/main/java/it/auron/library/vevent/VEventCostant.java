/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Rurio Luca
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
package it.auron.library.vevent;

/**
 * Created by Luca on 29/06/2017.
 */

public class VEventCostant {

    public static final String KEY_BEGIN_VEVENT = "BEGIN:VEVENT";
    public static final String KEY_END_VEVENT = "END:VEVENT";
    public static final String KEY_SEPARATOR = "\r?\n";
    public static final String KEY_SPLIT = ":";
    public static final String KEY_LINE_ESCAPE = "\n";

    public static final String KEY_SUMMARY = "SUMMARY";
    public static final String KEY_URL = "URL";
    public static final String KEY_LOCATION = "LOCATION";
    public static final String KEY_DTSTART = "DTSTART";
    public static final String KEY_DTEND = "DTEND";
    public static final String DATE_FORMAT = "YYYYMMdd'T'hhmmss'Z'";
}
