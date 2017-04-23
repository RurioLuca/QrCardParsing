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

    private List<String> telephone = new ArrayList<>();

    private List<String> email = new ArrayList<>();

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

    public List<String> getTelephone() {
        return telephone;
    }

    public void setTelephone(List<String> telephone) {
        this.telephone = telephone;
    }


    public void addTelephone(String telephone) {
        this.telephone.add(telephone);
    }

    public void removeTelephone(String telephone) {
        for (int i = 0; i < this.telephone.size(); i++) {
            if (this.telephone.get(i).equals(telephone)) {
                this.telephone.remove(i);
                break;
            }
        }
    }

    public void removTelephone(int index) {
        this.telephone.remove(index);
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public void addEmail(String email) {
        this.email.add(email);
    }

    public void removeEmail(String email) {
        for (int i = 0; i < this.email.size(); i++) {
            if (this.email.get(i).equals(email)) {
                this.email.remove(i);
                break;
            }
        }
    }

    public void removeEmail(int index) {
        this.email.remove(index);
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

        if (email.size() != 0) {
            for (String s : email) {
                if (!TextUtils.isEmpty(s)) {
                    meCardString.append(VCardCostant.KEY_LINE_ESCAPE).append(VCardCostant.KEY_EMAIL).append(":").append(s);
                }
            }
        }

        if (telephone.size() != 0) {
            for (String s : telephone) {
                if (!TextUtils.isEmpty(s)) {
                    meCardString.append(VCardCostant.KEY_LINE_ESCAPE).append(VCardCostant.KEY_EMAIL).append(":").append(s);
                }
            }
        }

        meCardString.append(VCardCostant.KEY_LINE_ESCAPE).append(VCardCostant.KEY_END_VCARD);

        return meCardString.toString();

    }
}
