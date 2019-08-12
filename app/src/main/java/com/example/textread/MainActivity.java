package com.example.textread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    List<String> list;
    List<String> listPalavra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<String>();
        listPalavra = new ArrayList<String>();

        try {
            DataInputStream textFileStream = new DataInputStream(getAssets().open(String.format("Teste.txt")));
            Scanner sc = new Scanner(textFileStream);
            while (sc.hasNextLine()) {
                String linha = sc.next();
                list.add(linha);
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



//
//        while(tentativas <= 10) {
//            try {
//                sleep(2000);
//                texto.setText(list.get(gerador.nextInt(list.size())));
//                tentativas ++;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Integer tentativas = 0;
                    while(tentativas <= 10) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView texto = findViewById(R.id.textView);
                                Random gerador = new Random();
                                texto.setText(list.get(gerador.nextInt(list.size())));

                            }
                        });
                    }
                    tentativas++;
                } catch (InterruptedException e) {
                }
            }
        };
        thread.start();


    Log.i("Lista: ", list.toString());

    }
}
