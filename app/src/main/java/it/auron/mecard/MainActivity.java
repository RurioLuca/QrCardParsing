package it.auron.mecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import it.auron.library.MeCard;
import it.auron.library.MeCardParser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String meCardString = "MECARD:N:Rurio Luca;TEL:+39 3486454313;EMAIL:rurio.luca@gmail.com;URL:https://github.com/RurioLuca;NOTE:generate MeCard!;BDAY:1989-06-19;ADR:via del corso , Rome , Italy;";
        MeCard meCard = MeCardParser.parse(meCardString);
        Log.d(MainActivity.class.getSimpleName(), "meCard object: " + meCard.buildString());
        TextView textView = (TextView) findViewById(R.id.mecard);
        meCard.setNote("MeCard generate and modified!");
        textView.setText(meCard.buildString());

    }
}
