package com.jirayut.snrurun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
    }
    public void clickNamOun(View view) {
        startActivity(new Intent(ShowActivity.this, NamOunActivity.class));
    }
    public void clickPuPex(View view) {
        startActivity(new Intent(ShowActivity.this, PuPexActivity.class));
    }
    public void clickCengCum(View view) {
        startActivity(new Intent(ShowActivity.this, CengCumActivity.class));
    }
    public void clickJengWeng(View view) {
        startActivity(new Intent(ShowActivity.this, JengWengActivity.class));
    }
    public void clickArJaLo(View view) {
        startActivity(new Intent(ShowActivity.this, ArJaLoActivity.class));
    }
    public void clickDoom(View view) {
        startActivity(new Intent(ShowActivity.this, DoomActivity.class));
    }
    public void clickNamPung(View view) {
        startActivity(new Intent(ShowActivity.this, NamPungActivity.class));
    }
}
