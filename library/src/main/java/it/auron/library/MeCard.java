package it.auron.library;

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
            meCardString.append(MeCardCostant.KEY_NAME);
            meCardString.append(name);
            meCardString.append(";");
        }

        if (!TextUtils.isEmpty(address)) {
            meCardString.append(MeCardCostant.KEY_ADDRESS);
            meCardString.append(address);
            meCardString.append(";");
        }

        if (!TextUtils.isEmpty(url)) {
            meCardString.append(MeCardCostant.KEY_URL);
            meCardString.append(url);
            meCardString.append(";");
        }

        if (!TextUtils.isEmpty(note)) {
            meCardString.append(MeCardCostant.KEY_NOTE);
            meCardString.append(note);
            meCardString.append(";");
        }

        if (!TextUtils.isEmpty(date)) {
            meCardString.append(MeCardCostant.KEY_DAY);
            meCardString.append(date);
            meCardString.append(";");
        }
        if (!TextUtils.isEmpty(email)) {
            meCardString.append(MeCardCostant.KEY_EMAIL);
            meCardString.append(email);
            meCardString.append(";");
        }
        if (telephones != null)

            for (String telephone : telephones) {

                meCardString.append(MeCardCostant.KEY_TELEPHONE);
                meCardString.append(telephone);
                meCardString.append(";");

            }


        return meCardString.toString();

    }

}
