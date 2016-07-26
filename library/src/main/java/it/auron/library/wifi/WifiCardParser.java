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

/**
 * Created by luca on 7/22/16.
 */
public class WifiCardParser {

    public static WifiCard parse(String wifiCardContent) {
        WifiCard wifiCard = new WifiCard();

        if (!wifiCardContent.startsWith(WifiCostant.KEY_WIFI)) {
            return null;
        }

        wifiCardContent = wifiCardContent.substring(WifiCostant.KEY_WIFI.length(), wifiCardContent.length());

        StringTokenizer st = new StringTokenizer(wifiCardContent, ";");
        while (st.hasMoreTokens()) {
            executeParsing(wifiCard, st.nextToken());
        }


        return wifiCard;
    }

    private static void executeParsing(WifiCard wifiCard, String tokenparsing) {

        if (tokenparsing.startsWith(WifiCostant.KEY_SID)) {
            wifiCard.setSid(tokenparsing.substring(WifiCostant.KEY_SID.length(), tokenparsing.length()));
        }

        if (tokenparsing.startsWith(WifiCostant.KEY_PASS)) {
            wifiCard.setPassword(tokenparsing.substring(WifiCostant.KEY_PASS.length(), tokenparsing.length()));
        }

        if (tokenparsing.startsWith(WifiCostant.KEY_TYPE)) {
            wifiCard.setType(tokenparsing.substring(WifiCostant.KEY_TYPE.length(), tokenparsing.length()));
        }

    }


}
