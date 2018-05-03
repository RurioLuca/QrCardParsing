package it.auron.library.geolocation;

public class GeoCard {

    private double lat;
    private double lon;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String buildString() {

        StringBuilder geoCardString = new StringBuilder();

        geoCardString.append(GeoCostant.KEY_GEO)
                .append(lat)
                .append(",")
                .append(lon);

        return geoCardString.toString();

    }
}
