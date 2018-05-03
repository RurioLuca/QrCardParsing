package it.auron.mecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import net.glxn.qrgen.android.QRCode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import it.auron.library.vevent.VEvent;
import it.auron.library.vevent.VEventCostant;
import it.auron.library.vevent.VEventParser;

/**
 * Created by Luca on 29/06/2017.
 */

public class VEventActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    //private Button addToCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vevent);
        setTitle("VEVENT");
        textView = (TextView) findViewById(R.id.vcard);
        imageView = (ImageView) findViewById(R.id.qrcode);
        // addToCalendar = (Button) findViewById(R.id.addtocal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String vEventString = "BEGIN:VEVENT\n" +
                "SUMMARY:Google IO\n" +
                "LOCATION:Shoreline Amphitheatre Mountain View, California\n" +
                "DTSTART:20170611T130000Z\n" +
                "DTEND:20170611T153400Z\n" +
                "END:VEVENT";

        final VEvent vEvent = VEventParser.parse(vEventString);
        vEvent.setSummary("Google I/O");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(VEventCostant.DATE_FORMAT);
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(simpleDateFormat.parse(vEvent.getDtEnd()));
            calendar.set(Calendar.DAY_OF_MONTH, 12);
            calendar.set(Calendar.HOUR_OF_DAY, 14);
            calendar.set(Calendar.MINUTE, 00);
            vEvent.setDtEnd(simpleDateFormat.format(calendar.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        String vEventcontent = vEvent.buildString();

        textView.setText(vEventcontent);
        imageView.setImageBitmap(QRCode.from(vEventcontent).bitmap());

      /*  addToCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vEvent.addToCalendar(VEventActivity.this);
            }
        });
      */
    }

    @Override
    public boolean onSupportNavigateUp() {
        this.finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mecard:
                this.finish();
                return true;
            case R.id.wifiCard:
                startActivity(new Intent(VEventActivity.this, WifiActivity.class));
                this.finish();
                return true;
            case R.id.vcard:
                startActivity(new Intent(VEventActivity.this, VCardActivty.class));
                this.finish();
                return true;
            case R.id.vevent:
                return true;
            case R.id.geocard:
                startActivity(new Intent(VEventActivity.this, GeoCardActivity.class));
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
