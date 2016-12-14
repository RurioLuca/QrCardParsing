package it.auron.mecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.glxn.qrgen.android.QRCode;

import it.auron.library.mecard.MeCard;
import it.auron.library.mecard.MeCardParser;

@SuppressWarnings("ConstantConditions")
public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private Button button,wifiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.mecard);
        imageView = (ImageView) findViewById(R.id.qrcode);
        button = (Button) findViewById(R.id.btn);
        wifiButton= (Button) findViewById(R.id.btnwifi);
        String meCardString = "MECARD:N:Luca;TEL:+39 3486454313;EMAIL:rurio.luca@gmail.com;URL:https://github.com/RurioLuca;NOTE:generate MeCard!;BDAY:1989-07-19;ADR:via del corso , Rome , Italy;";
        MeCard meCard = MeCardParser.parse(meCardString);

        meCard.setSurname("Rurio");
        meCard.setNote("MeCard generate and modified!");
        meCard.addTelephone("+39 3476512321");

        String meCardcontent = meCard.buildString();

        textView.setText(meCardcontent);
        imageView.setImageBitmap(QRCode.from(meCardcontent).bitmap());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VCardActivty.class);
                startActivity(intent);
            }
        });

        wifiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WifiActivity.class);
                startActivity(intent);
            }
        });
    }


}
