package it.auron.mecard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import net.glxn.qrgen.android.QRCode;

import it.auron.library.MeCard;
import it.auron.library.MeCardParser;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.mecard);
        imageView = (ImageView) findViewById(R.id.qrcode);
        String meCardString = "MECARD:N:Rurio Luca;TEL:+39 3486454313;EMAIL:rurio.luca@gmail.com;URL:https://github.com/RurioLuca;NOTE:generate MeCard!;BDAY:1989-07-19;ADR:via del corso , Rome , Italy;";
        MeCard meCard = MeCardParser.parse(meCardString);

        meCard.setNote("MeCard generate and modified!");
        meCard.addTelephone("+39 3476512321");

        String meCardcontent = meCard.buildString();

        textView.setText(meCardcontent);
        imageView.setImageBitmap(QRCode.from(meCardcontent).bitmap());
    }


}
