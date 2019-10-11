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

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by Luca on 29/06/2017.
 */

public class VEventParser {


    public static VEvent parse(String vEventContent) {
        VEvent vEvent = new VEvent();

        if (!isVEvent(vEventContent)) {
            return null;
        }

        vEventContent = vEventContent.substring(VEventCostant.KEY_BEGIN_VEVENT.length());
        StringTokenizer st = new StringTokenizer(vEventContent, ";");
        while (st.hasMoreTokens()) {
            executeParsing(vEvent, st.nextToken());
        }


        return vEvent;
    }

    public static Boolean isVEvent(String vEventContent) {
        return vEventContent.startsWith(VEventCostant.KEY_BEGIN_VEVENT);
    }

    private static void executeParsing(VEvent vEvent, String tokenparsing) {
        Map<String, String> vEventValue = populateMap(tokenparsing);


        if (vEventValue.containsKey(VEventCostant.KEY_SUMMARY)) {
            vEvent.setSummary(vEventValue.get(VEventCostant.KEY_SUMMARY));
        }

        if (vEventValue.containsKey(VEventCostant.KEY_URL)) {
            vEvent.setUrl(vEventValue.get(VEventCostant.KEY_URL));
        }

        if (vEventValue.containsKey(VEventCostant.KEY_LOCATION)) {
            vEvent.setLocation(vEventValue.get(VEventCostant.KEY_LOCATION));
        }

        if (vEventValue.containsKey(VEventCostant.KEY_DTSTART)) {

            vEvent.setDtStart(vEventValue.get(VEventCostant.KEY_DTSTART));
        }

        if (vEventValue.containsKey(VEventCostant.KEY_DTEND)) {
            vEvent.setDtEnd(vEventValue.get(VEventCostant.KEY_DTEND));
        }
    }

    public static Map<String, String> populateMap(String vEventContent) {

        Map<String, String> map = new HashMap<>();

        for (String s : vEventContent.split(VEventCostant.KEY_SEPARATOR)) {

            String[] value = s.split(VEventCostant.KEY_SPLIT);

            if (value.length == 2) {
                map.put(value[0], value[1]);
            }

            if (value.length > 2 && value[0].equals(VEventCostant.KEY_URL)) {
                map.put(value[0], value[1] + ":" + value[2]);
            }
        }


        return map;
    }
}
