package it.auron.library.vevent;

import android.text.TextUtils;

/**
 * Created by Luca on 29/06/2017.
 */

public class VEvent {

    private String summary;
    private String location;
    private String url;
    private String dtStart;
    private String dtEnd;


    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDtStart() {
        return dtStart;
    }

    public void setDtStart(String dtStart) {
        this.dtStart = dtStart;
    }

    public String getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(String dtEnd) {
        this.dtEnd = dtEnd;
    }

    public String buildString() {

        StringBuilder vEventString = new StringBuilder();

        vEventString.append(VEventCostant.KEY_BEGIN_VEVENT).append(VEventCostant.KEY_LINE_ESCAPE);

        if (!TextUtils.isEmpty(summary)) {
            vEventString.append(VEventCostant.KEY_SUMMARY).append(":").append(summary);
        }
        if (!TextUtils.isEmpty(location)) {
            vEventString.append(VEventCostant.KEY_LINE_ESCAPE).append(VEventCostant.KEY_LOCATION).append(":").append(location);
        }

        if (!TextUtils.isEmpty(url)) {
            vEventString.append(VEventCostant.KEY_LINE_ESCAPE).append(VEventCostant.KEY_URL).append(":").append(url);
        }

        if (dtStart != null) {
            vEventString.append(VEventCostant.KEY_LINE_ESCAPE).append(VEventCostant.KEY_DTSTART).append(":").append(dtStart);
        }

        if (dtEnd != null) {
            vEventString.append(VEventCostant.KEY_LINE_ESCAPE).append(VEventCostant.KEY_DTEND).append(":").append(dtEnd);
        }

        vEventString.append(VEventCostant.KEY_LINE_ESCAPE).append(VEventCostant.KEY_END_VEVENT);

        return vEventString.toString();

    }

    /*
    public void addToCalendar(Context context) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(VEventCostant.DATE_FORMAT);
        ContentResolver cr = context.getContentResolver();
        ContentValues values = new ContentValues();
        try {
            values.put(CalendarContract.Events.DTSTART, simpleDateFormat.parse(dtStart).getTime());
            values.put(CalendarContract.Events.DTEND, simpleDateFormat.parse(dtEnd).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        values.put(CalendarContract.Events.TITLE, summary);
        values.put(CalendarContract.Events.EVENT_LOCATION, location);
        values.put(CalendarContract.Events.CALENDAR_ID, new Random().nextInt(20));
        //  values.put(CalendarContract.Events.EVENT_TIMEZONE, "America/Los_Angeles");
        Uri uri = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);
        }
    }
    */
}
