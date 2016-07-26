package it.auron.mecard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import net.glxn.qrgen.android.QRCode;

import it.auron.library.vcard.VCard;
import it.auron.library.vcard.VCardParser;

/**
 * Created by luca on 7/26/16.
 */
public class VCardActivty extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vcard);
        setTitle("VCard");
        textView = (TextView) findViewById(R.id.vcard);
        imageView = (ImageView) findViewById(R.id.qrcode);

        String vCardString = "MECARD:N:Rurio Luca;TEL:+39 3486454313;EMAIL:rurio.luca@gmail.com;URL:https://github.com/RurioLuca;NOTE:generate MeCard!;BDAY:1989-07-19;ADR:via del corso , Rome , Italy;";
        VCard vCard = VCardParser.parse(vCardString);

        vCard.setNote("vCard generate and modified!");
        vCard.setPhoneNumber("+39 3486454314");

        String vCardcontent = vCard.buildString();

        textView.setText(vCardcontent);
        imageView.setImageBitmap(QRCode.from(vCardcontent).bitmap());

    }


}
