package com.example.textread.readText;

import android.app.Activity;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class ReadTextThread extends Thread {
    private final Activity activity;
    List<String> list;
    TextView texto;
    Random gerador = new Random();
    Integer tentativas;

    public ReadTextThread(Activity activity, TextView textView, List<String> list) {
        this.texto = textView;
        this.list = list;
        this.activity = activity;
    }

    public Thread thread() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    tentativas = 0;
                    while (tentativas <= 10) {
                        Thread.sleep(1000);
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                texto.setText(list.get(gerador.nextInt(list.size())));
                                tentativas++;
                            }
                        });
                    }

                } catch (InterruptedException e) {
                }
            }
        };
        return thread;
    }
}
