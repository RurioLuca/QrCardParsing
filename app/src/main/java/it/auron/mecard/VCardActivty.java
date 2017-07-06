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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("VCard");
        textView = (TextView) findViewById(R.id.vcard);
        imageView = (ImageView) findViewById(R.id.qrcode);

        String vCardString = "BEGIN:VCARD\n" +
                "N:Luca\n" +
                "FN:Rurio Luca\n" +
                "ORG:freelancer\n" +
                "TITLE:Developer\n" +
                "EMAIL:rurio.luca@gmail.com\n" +
                "URL:https://yoursite.com\n" +
                "END:VCARD";

        VCard vCard = VCardParser.parse(vCardString);

        vCard.setNote("vCard generate and modified!");
        vCard.addTelephone("+39 3486454314");
        vCard.addTelephone("+39 3486488888");
        vCard.addEmail("rurio.luca@github.com");
        String vCardcontent = vCard.buildString();

        textView.setText(vCardcontent);
        imageView.setImageBitmap(QRCode.from(vCardcontent).bitmap());


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
                startActivity(new Intent(VCardActivty.this, WifiActivity.class));
                this.finish();
                return true;
            case R.id.vcard:
                return true;
            case R.id.vevent:
                startActivity(new Intent(VCardActivty.this, VEventActivity.class));
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
