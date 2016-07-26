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


package it.auron.library.wifi;


import java.util.StringTokenizer;

import it.auron.library.mecard.MeCardCostant;
import it.auron.library.vcard.VCard;
import it.auron.library.vcard.VCardCostant;

/**
 * Created by luca on 7/22/16.
 */
public class WifiCardParser {

    public static VCard parse(String meCardContent) {
        VCard vCard = new VCard();

        if (!meCardContent.startsWith(MeCardCostant.KEY_MECARD)) {
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

        if (tokenparsing.startsWith(VCardCostant.KEY_NAME)) {
            vCard.setName(tokenparsing.substring(VCardCostant.KEY_NAME.length(), tokenparsing.length()));
        }

        if (tokenparsing.startsWith(VCardCostant.KEY_ADDRESS)) {
            vCard.setAddress(tokenparsing.substring(VCardCostant.KEY_ADDRESS.length(), tokenparsing.length()));
        }

        if (tokenparsing.startsWith(VCardCostant.KEY_PHONE)) {
            vCard.setPhoneNumber(tokenparsing.substring(VCardCostant.KEY_PHONE.length(), tokenparsing.length()));
        }
        if (tokenparsing.startsWith(VCardCostant.KEY_WEB)) {
            vCard.setWebsite(tokenparsing.substring(VCardCostant.KEY_WEB.length(), tokenparsing.length()));
        }
        if (tokenparsing.startsWith(VCardCostant.KEY_NOTE)) {
            vCard.setNote(tokenparsing.substring(VCardCostant.KEY_NOTE.length(), tokenparsing.length()));
        }
        if (tokenparsing.startsWith(VCardCostant.KEY_EMAIL)) {
            vCard.setEmail(tokenparsing.substring(VCardCostant.KEY_EMAIL.length(), tokenparsing.length()));
        }
        if (tokenparsing.startsWith(VCardCostant.KEY_TITLE)) {
            vCard.setTitle(tokenparsing.substring(VCardCostant.KEY_TITLE.length(), tokenparsing.length()));
        }
        if (tokenparsing.startsWith(VCardCostant.KEY_COMPANY)) {
            vCard.setCompany(tokenparsing.substring(VCardCostant.KEY_COMPANY.length(), tokenparsing.length()));
        }
    }


}
