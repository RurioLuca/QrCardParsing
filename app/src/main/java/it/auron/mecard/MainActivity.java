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
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import net.glxn.qrgen.android.QRCode;

import it.auron.library.mecard.MeCard;
import it.auron.library.mecard.MeCardParser;


public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.mecard);
        imageView = findViewById(R.id.qrcode);

        String meCardString = "MECARD:N:Luca;TEL:+39 3486454313;EMAIL:rurio.luca@gmail.com;URL:https://github.com/RurioLuca;NOTE:generate MeCard!;BDAY:1989-07-19;ADR:via del corso , Rome , Italy;ORG:your company;";
        MeCard meCard = MeCardParser.parse(meCardString);

        meCard.setSurname("Rurio");
        meCard.setNote("MeCard generate and modified!");
        meCard.addTelephone("+39 3476512321");

        String meCardcontent = meCard.buildString();

        textView.setText(meCardcontent);
        imageView.setImageBitmap(QRCode.from(meCardcontent).bitmap());

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
                return true;
            case R.id.wifiCard:
                startActivity(new Intent(MainActivity.this, WifiActivity.class));
                return true;
            case R.id.vcard:
                startActivity(new Intent(MainActivity.this, VCardActivty.class));
                return true;
            case R.id.vevent:
                startActivity(new Intent(MainActivity.this, VEventActivity.class));
                return true;
            case R.id.geocard:
                startActivity(new Intent(MainActivity.this, GeoCardActivity.class));
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
