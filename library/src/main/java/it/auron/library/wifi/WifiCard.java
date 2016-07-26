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

import android.text.TextUtils;

/**
 * Created by luca on 7/26/16.
 */
public class WifiCard {

    private String sid;
    private String password;
    private String type;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String buildString() {

        StringBuilder wifiCardString = new StringBuilder();
        wifiCardString.append(WifiCostant.KEY_WIFI);

        if (!TextUtils.isEmpty(sid)) {
            wifiCardString.append(WifiCostant.KEY_SID)
                    .append(sid)
                    .append(";");
        }

        if (!TextUtils.isEmpty(password)) {
            wifiCardString.append(WifiCostant.KEY_PASS)
                    .append(password)
                    .append(";");
        }

        if (!TextUtils.isEmpty(type)) {
            wifiCardString.append(WifiCostant.KEY_TYPE)
                    .append(type)
                    .append(";");
        }


        return wifiCardString.toString();

    }
}
