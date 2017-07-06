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

import it.auron.library.wifi.WifiCard;
import it.auron.library.wifi.WifiCardParser;

/**
 * Created by luca on 7/26/16.
 */
public class WifiActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);
        setTitle("WifiCard");
        textView = (TextView) findViewById(R.id.wificard);
        imageView = (ImageView) findViewById(R.id.qrcode);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String wifiString = "WIFI:S:Vodafone Wifi32341;T:WPA;P:administrator;;";
        WifiCard wifiCard = WifiCardParser.parse(wifiString);

        wifiCard.setPassword("administrator2016");


        String wifiCardcontent = wifiCard.buildString();

        textView.setText(wifiCardcontent);
        imageView.setImageBitmap(QRCode.from(wifiCardcontent).bitmap());


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

                return true;
            case R.id.vcard:
                startActivity(new Intent(WifiActivity.this, VCardActivty.class));
                this.finish();
                return true;
            case R.id.vevent:
                startActivity(new Intent(WifiActivity.this, VEventActivity.class));
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
