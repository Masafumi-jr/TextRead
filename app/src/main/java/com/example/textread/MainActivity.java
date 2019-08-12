package com.example.textread;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.textread.readText.LeitorTexto;
import com.example.textread.readText.ReadTextThread;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> list;
    LeitorTexto leTexto;
    ReadTextThread readTextThread;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.textView);

        //Cria Leitor texto Scanner
        leTexto = new LeitorTexto();
        list = leTexto.retornaLista(this, "Teste.txt");

        //Cria Thread de execução de update na Tela.
        readTextThread = new ReadTextThread(this, texto, list);
        Thread thread = readTextThread.thread();

        thread.start();
        Log.i("Lista: ", this.list.toString());

    }
}
