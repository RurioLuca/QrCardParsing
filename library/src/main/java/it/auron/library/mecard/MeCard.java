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


package it.auron.library.mecard;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luca on 7/22/16.
 */
public class MeCard {

    private String name;
    private String address;
    private String email;
    private List<String> telephones;
    private String url;
    private String note;
    private String date;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }

    public void addTelephone(String telephone) {
        if (telephones == null) {
            telephones = new ArrayList<>();
        }
        telephones.add(telephone);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String buildString() {

        StringBuilder meCardString = new StringBuilder();
        meCardString.append(MeCardCostant.KEY_MECARD);

        if (!TextUtils.isEmpty(name)) {
            meCardString.append(MeCardCostant.KEY_NAME)
                    .append(name)
                    .append(";");
        }

        if (!TextUtils.isEmpty(address)) {
            meCardString.append(MeCardCostant.KEY_ADDRESS)
                    .append(address)
                    .append(";");
        }

        if (!TextUtils.isEmpty(url)) {
            meCardString.append(MeCardCostant.KEY_URL)
                    .append(url)
                    .append(";");
        }

        if (!TextUtils.isEmpty(note)) {
            meCardString.append(MeCardCostant.KEY_NOTE)
                    .append(note)
                    .append(";");
        }

        if (!TextUtils.isEmpty(date)) {
            meCardString.append(MeCardCostant.KEY_DAY)
                    .append(date)
                    .append(";");
        }
        if (!TextUtils.isEmpty(email)) {
            meCardString.append(MeCardCostant.KEY_EMAIL)
                    .append(email)
                    .append(";");
        }
        if (telephones != null)

            for (String telephone : telephones) {

                meCardString.append(MeCardCostant.KEY_TELEPHONE)
                        .append(telephone)
                        .append(";");

            }


        return meCardString.toString();

    }

}
