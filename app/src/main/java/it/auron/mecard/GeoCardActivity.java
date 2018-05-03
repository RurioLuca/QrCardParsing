package it.auron.mecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import net.glxn.qrgen.android.QRCode;

import it.auron.library.geolocation.GeoCard;
import it.auron.library.geolocation.GeoCardParser;

public class GeoCardActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);
        setTitle("GeolocationCard");
        textView = (TextView) findViewById(R.id.geocard);
        imageView = (ImageView) findViewById(R.id.qrcode);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String geoString = "geo:20.33470,20.39448";
        GeoCard geoCard = GeoCardParser.parse(geoString);

        geoCard.setLat(41.8919300);
        geoCard.setLon(12.5113300);


        String geoCardcontent = geoCard.buildString();

        textView.setText(geoCardcontent);
        imageView.setImageBitmap(QRCode.from(geoCardcontent).bitmap());


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
                startActivity(new Intent(GeoCardActivity.this, VCardActivty.class));
                this.finish();
                return true;
            case R.id.vcard:
                startActivity(new Intent(GeoCardActivity.this, VCardActivty.class));
                this.finish();
                return true;
            case R.id.vevent:
                startActivity(new Intent(GeoCardActivity.this, VEventActivity.class));
                this.finish();
                return true;
            case R.id.geocard:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
