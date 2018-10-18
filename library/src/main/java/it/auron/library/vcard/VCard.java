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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luca on 7/26/16.
 */
public class VCard {

    private String name;

    private String formattedName;

    private String company;

    private String title;

    private List<String> telephones = new ArrayList<>();

    private List<String> emails = new ArrayList<>();

    private String address;

    private String url;

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


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getFormattedName() {
        return formattedName;
    }

    public void setFormattedName(String formattedName) {
        this.formattedName = formattedName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<String> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }

    public void setTelephone(String oldNumber, String newNumber) {
        for (int i = 0; i < this.telephones.size(); i++) {
            if (this.telephones.get(i).equals(oldNumber)) {
                this.telephones.set(i, newNumber);
            }
        }
    }

    public void addTelephone(String telephone) {
        this.telephones.add(telephone);
    }

    public void removeTelephone(String telephone) {
        for (int i = 0; i < this.telephones.size(); i++) {
            if (this.telephones.get(i).equals(telephone)) {
                this.telephones.remove(i);
                break;
            }
        }
    }

    public void removTelephone(int index) {
        this.telephones.remove(index);
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public void setEmail(String oldEmail, String newEmail) {
        for (int i = 0; i < this.emails.size(); i++) {
            if (this.emails.get(i).equals(oldEmail)) {
                this.emails.set(i, newEmail);
            }
        }
    }

    public void addEmail(String email) {
        this.emails.add(email);
    }

    public void removeEmail(String email) {
        for (int i = 0; i < this.emails.size(); i++) {
            if (this.emails.get(i).equals(email)) {
                this.emails.remove(i);
                break;
            }
        }
    }

    public void removeEmail(int index) {
        this.emails.remove(index);
    }

    public String buildString() {

        StringBuilder meCardString = new StringBuilder();

        meCardString.append(VCardCostant.KEY_BEGIN_VCARD).append(VCardCostant.KEY_LINE_ESCAPE);
        meCardString.append(VCardCostant.KEY_VERSION).append(VCardCostant.KEY_LINE_ESCAPE);

        if (!TextUtils.isEmpty(name)) {
            meCardString.append(VCardCostant.KEY_NAME).append(":").append(name);
        }
        if (!TextUtils.isEmpty(formattedName)) {
            meCardString.append(VCardCostant.KEY_LINE_ESCAPE).append(VCardCostant.KEY_FORMATTEDNAME).append(":").append(formattedName);
        }

        if (!TextUtils.isEmpty(address)) {
            meCardString.append(VCardCostant.KEY_LINE_ESCAPE).append(VCardCostant.KEY_ADDRESS).append(":").append(address);
        }

        if (!TextUtils.isEmpty(company)) {
            meCardString.append(VCardCostant.KEY_LINE_ESCAPE).append(VCardCostant.KEY_COMPANY).append(":").append(company);
        }

        if (!TextUtils.isEmpty(title)) {
            meCardString.append(VCardCostant.KEY_LINE_ESCAPE).append(VCardCostant.KEY_TITLE).append(":").append(title);
        }

        if (!TextUtils.isEmpty(url)) {
            meCardString.append(VCardCostant.KEY_LINE_ESCAPE).append(VCardCostant.KEY_WEB).append(":").append(url);
        }

        if (!TextUtils.isEmpty(note)) {
            meCardString.append(VCardCostant.KEY_LINE_ESCAPE).append(VCardCostant.KEY_NOTE).append(":").append(note);
        }

        if (emails.size() != 0) {
            for (String s : emails) {
                if (!TextUtils.isEmpty(s)) {
                    meCardString.append(VCardCostant.KEY_LINE_ESCAPE).append(VCardCostant.KEY_EMAIL).append(":").append(s);
                }
            }
        }

        if (telephones.size() != 0) {
            for (String s : telephones) {
                if (!TextUtils.isEmpty(s)) {
                    meCardString.append(VCardCostant.KEY_LINE_ESCAPE).append(VCardCostant.KEY_PHONE).append(":").append(s);
                }
            }
        }

        meCardString.append(VCardCostant.KEY_LINE_ESCAPE).append(VCardCostant.KEY_END_VCARD);

        return meCardString.toString();

    }
}
