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

import android.text.TextUtils;

/**
 * Created by luca on 7/26/16.
 */
public class VCard {

    private String name;

    private String company;

    private String title;

    private String phoneNumber;

    private String email;

    private String address;

    private String website;

    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String buildString() {

        StringBuilder meCardString = new StringBuilder();
        meCardString.append(VCardCostant.KEY_BEGIN_VCARD);

        if (!TextUtils.isEmpty(name)) {
            meCardString.append(VCardCostant.KEY_NAME)
                    .append(name)
                    .append(";");
        }

        if (!TextUtils.isEmpty(address)) {
            meCardString.append(VCardCostant.KEY_ADDRESS)
                    .append(address)
                    .append(";");
        }

        if (!TextUtils.isEmpty(company)) {
            meCardString.append(VCardCostant.KEY_COMPANY)
                    .append(company)
                    .append(";");
        }

        if (!TextUtils.isEmpty(title)) {
            meCardString.append(VCardCostant.KEY_TITLE)
                    .append(title)
                    .append(";");
        }

        if (!TextUtils.isEmpty(website)) {
            meCardString.append(VCardCostant.KEY_WEB)
                    .append(website)
                    .append(";");
        }

        if (!TextUtils.isEmpty(note)) {
            meCardString.append(VCardCostant.KEY_NOTE)
                    .append(note)
                    .append(";");
        }


        if (!TextUtils.isEmpty(email)) {
            meCardString.append(VCardCostant.KEY_EMAIL)
                    .append(email)
                    .append(";");
        }

        if (!TextUtils.isEmpty(phoneNumber)) {
            meCardString.append(VCardCostant.KEY_EMAIL)
                    .append(email)
                    .append(";");
        }


        return meCardString.toString();

    }
}
