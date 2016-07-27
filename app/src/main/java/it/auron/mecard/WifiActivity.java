package it.auron.mecard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        String wifiString = "WIFI:S:Vodafone Wifi32341;T:WPA;P:administrator;;";
        WifiCard wifiCard = WifiCardParser.parse(wifiString);

        wifiCard.setPassword("administrator2016");


        String wifiCardcontent = wifiCard.buildString();

        textView.setText(wifiCardcontent);
        imageView.setImageBitmap(QRCode.from(wifiCardcontent).bitmap());

       
    }
}
