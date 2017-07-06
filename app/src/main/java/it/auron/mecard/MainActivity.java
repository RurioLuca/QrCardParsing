package it.auron.mecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.mecard);
        imageView = (ImageView) findViewById(R.id.qrcode);

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
            case R.id.vcard :
                startActivity(new Intent(MainActivity.this, VCardActivty.class));
                return true;
            case R.id.vevent :
                startActivity(new Intent(MainActivity.this, VEventActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
