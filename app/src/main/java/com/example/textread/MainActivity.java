package com.example.textread;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.textread.telasJogos.TelaJogo;

public class MainActivity extends AppCompatActivity {

    TelaJogo telaJogo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        telaJogo = new TelaJogo(this);

        setContentView(telaJogo);

    }

    @Override
    protected void onResume() {
        super.onResume();
        telaJogo.resume();
    }
}