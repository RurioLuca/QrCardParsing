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


package it.auron.library.vcard;

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

import android.util.Log;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import it.auron.library.mecard.MeCardCostant;

/**
 * Created by luca on 7/22/16.
 */
public class VCardParser {

    public static VCard parse(String meCardContent) {
        VCard vCard = new VCard();

        if (!meCardContent.startsWith(VCardCostant.KEY_BEGIN_VCARD)) {
            return null;
        }

        meCardContent = meCardContent.substring(VCardCostant.KEY_BEGIN_VCARD.length(), meCardContent.length());
        StringTokenizer st = new StringTokenizer(meCardContent, ";");
        while (st.hasMoreTokens()) {
            executeParsing(vCard, st.nextToken());
        }


        return vCard;
    }

    private static void executeParsing(VCard vCard, String tokenparsing) {
        Map<String, String> vCardValue = populateMap(tokenparsing);


        if (vCardValue.containsKey(VCardCostant.KEY_NAME)) {
            vCard.setName(vCardValue.get(VCardCostant.KEY_NAME));
        }

        if (vCardValue.containsKey(VCardCostant.KEY_FORMATTEDNAME)) {
            vCard.setFormattedName(vCardValue.get(VCardCostant.KEY_FORMATTEDNAME));
        }

        if (vCardValue.containsKey(VCardCostant.KEY_TITLE)) {
            vCard.setTitle(vCardValue.get(VCardCostant.KEY_TITLE));
        }

        if (vCardValue.containsKey(VCardCostant.KEY_COMPANY)) {
            vCard.setCompany(vCardValue.get(VCardCostant.KEY_COMPANY));
        }

        if (vCardValue.containsKey(VCardCostant.KEY_ADDRESS)) {
            vCard.setAddress(vCardValue.get(VCardCostant.KEY_ADDRESS));
        }

        if (vCardValue.containsKey(VCardCostant.KEY_EMAIL)) {
            vCard.addEmail(vCardValue.get(VCardCostant.KEY_EMAIL));
        }

        if (vCardValue.containsKey(VCardCostant.KEY_WEB)) {
            vCard.setUrl(vCardValue.get(VCardCostant.KEY_WEB));
        }

        if (vCardValue.containsKey(VCardCostant.KEY_PHONE)) {
            vCard.addTelephone(vCardValue.get(VCardCostant.KEY_PHONE));
        }

        if (vCardValue.containsKey(VCardCostant.KEY_NOTE)) {
            vCard.setNote(vCardValue.get(VCardCostant.KEY_NOTE));
        }


    }


    public static Map<String, String> populateMap(String vCardContent) {

        Map<String, String> map = new HashMap<>();

        for (String s : vCardContent.split(VCardCostant.KEY_SEPARATOR)) {

            String value[] = s.split(VCardCostant.KEY_SPLIT);

            if (value.length == 2) {
                    map.put(value[0], value[1]);
            }

            if(value.length >2 && value[0].equals(VCardCostant.KEY_WEB)){
                    map.put(value[0], value[1]+":"+value[2]);
                }
            }


        return map;
    }

}
