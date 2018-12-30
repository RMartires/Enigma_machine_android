package com.example.rohit.enigmamachine;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> keys;
    ArrayList<String> keyhighlight;
    RecyclerView recyclerView;
    RecycleViewAdapter adapter;
    EditText editText;
    char keypressed='a';
    char keyenigma='a';
    String output="";
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keys = new ArrayList<>();
        keyhighlight= new ArrayList<>();

        for(char k='a';k<='z';k++){

           // Log.d("key",String.valueOf(k) );
            keys.add(String.valueOf(k));
        }

        recyclerView = findViewById(R.id.recyclerview);
        editText = findViewById(R.id.edittext);
        final TextView OutputTextView= findViewById(R.id.output);

        intrecycleview();


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(keyhighlight.size()>0)
                    keyhighlight.remove(keyhighlight.size()-1);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length()!=0) {
                    //key pressed
                    keypressed=charSequence.charAt(charSequence.length() - 1);
                    Log.v("keypressed", String.valueOf(keypressed));
                    //key o/p from enigma
                    keyenigma=Machine.rotorbox(keypressed);
                    Log.v("keyenigma", String.valueOf(keyenigma));
                    //high-light enigmakey
                    keyhighlight.add(String.valueOf(keyenigma));
                    output+=keyenigma;
                    OutputTextView.setText(output);
                    adapter.notifyDataSetChanged();
                    //normalise highlithedkey
                    keyhighlight.remove(String.valueOf(keyenigma));
                    adapter.notifyDataSetChanged();

                    Machine.keycountcheck();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }


    public void intrecycleview(){
        adapter = new RecycleViewAdapter(keys,keyhighlight);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,10));

    }





}
