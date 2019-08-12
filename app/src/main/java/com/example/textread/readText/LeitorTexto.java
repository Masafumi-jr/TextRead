package com.example.textread.readText;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeitorTexto {

    List<String> list = new ArrayList<String>();

    public List<String> retornaLista (Context context, String nomeTexto) {

        try {
            DataInputStream textFileStream = new DataInputStream(context.getAssets().open(String.format(nomeTexto)));
            Scanner sc = new Scanner(textFileStream);
            while (sc.hasNextLine()) {
                String linha = sc.next();
                list.add(linha);
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}

