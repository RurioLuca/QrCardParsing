package it.auron.library;

import android.util.Log;

import java.util.StringTokenizer;

/**
 * Created by luca on 7/22/16.
 */
public class MeCardParser {

    private static final String TAG = MeCardParser.class.getSimpleName();

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
