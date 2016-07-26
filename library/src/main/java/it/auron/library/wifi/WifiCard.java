package it.auron.library.wifi;

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
}
