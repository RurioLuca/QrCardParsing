/*
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2016 Rurio Luca
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package it.auron.mecard;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import net.glxn.qrgen.android.QRCode;
import it.auron.library.geolocation.*;

public class GeoCardActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);
        setTitle("GeolocationCard");
        textView = findViewById(R.id.geocard);
        imageView = findViewById(R.id.qrcode);
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
                startActivity(new Intent(GeoCardActivity.this, WifiActivity.class));
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
