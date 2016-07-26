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


package it.auron.library;


import java.util.StringTokenizer;

/**
 * Created by luca on 7/22/16.
 */
public class MeCardParser {

    public static MeCard parse(String meCardContent) {
        MeCard meCard = new MeCard();

        if (!meCardContent.startsWith(MeCardCostant.KEY_MECARD)) {
            return null;
        }

        meCardContent = meCardContent.substring(MeCardCostant.KEY_MECARD.length(), meCardContent.length());

        StringTokenizer st = new StringTokenizer(meCardContent, ";");
        while (st.hasMoreTokens()) {
            executeParsing(meCard,st.nextToken());
        }



        return meCard;
    }

    private static void executeParsing(MeCard meCard, String tokenparsing) {

        if (tokenparsing.startsWith(MeCardCostant.KEY_NAME)) {
            meCard.setName(tokenparsing.substring(MeCardCostant.KEY_NAME.length(), tokenparsing.length()));
        }

        if (tokenparsing.startsWith(MeCardCostant.KEY_ADDRESS)) {
            meCard.setAddress(tokenparsing.substring(MeCardCostant.KEY_ADDRESS.length(), tokenparsing.length()));
        }

        if (tokenparsing.startsWith(MeCardCostant.KEY_TELEPHONE)) {
            meCard.addTelephone(tokenparsing.substring(MeCardCostant.KEY_TELEPHONE.length(), tokenparsing.length()));
        }
        if (tokenparsing.startsWith(MeCardCostant.KEY_URL)) {
            meCard.setUrl(tokenparsing.substring(MeCardCostant.KEY_URL.length(), tokenparsing.length()));
        }
        if (tokenparsing.startsWith(MeCardCostant.KEY_NOTE)) {
            meCard.setNote(tokenparsing.substring(MeCardCostant.KEY_NOTE.length(), tokenparsing.length()));
        }
        if (tokenparsing.startsWith(MeCardCostant.KEY_EMAIL)) {
            meCard.setEmail(tokenparsing.substring(MeCardCostant.KEY_EMAIL.length(), tokenparsing.length()));
        }
        if (tokenparsing.startsWith(MeCardCostant.KEY_DAY)) {
            meCard.setDate(tokenparsing.substring(MeCardCostant.KEY_DAY.length(), tokenparsing.length()));
        }
    }


}
