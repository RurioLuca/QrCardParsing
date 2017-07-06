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

        if (!vEventContent.startsWith(VEventCostant.KEY_BEGIN_VEVENT)) {
            return null;
        }

        vEventContent = vEventContent.substring(VEventCostant.KEY_BEGIN_VEVENT.length(), vEventContent.length());
        StringTokenizer st = new StringTokenizer(vEventContent, ";");
        while (st.hasMoreTokens()) {
            executeParsing(vEvent, st.nextToken());
        }


        return vEvent;
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

            String value[] = s.split(VEventCostant.KEY_SPLIT);

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
