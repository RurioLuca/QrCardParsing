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

        String vCardString = "BEGIN:VCARD\n" +
                "N:Luca\n" +
                "FN:Rurio Luca\n" +
                "ORG:freelancer\n" +
                "TITLE:Developer\n" +
                "EMAIL:rurio.luca@gmail.com\n" +
                "END:VCARD";

        VCard vCard = VCardParser.parse(vCardString);

        vCard.setNote("vCard generate and modified!");
        vCard.setTelephone("+39 3486454314");
        String vCardcontent = vCard.buildString();

        textView.setText(vCardcontent);
        imageView.setImageBitmap(QRCode.from(vCardcontent).bitmap());


    }


}
