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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> keys;
    ArrayList<String> keyhighlight;
    RecyclerView recyclerView;
    RecycleViewAdapter adapter;
    EditText editText;
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
                    Log.v("key", String.valueOf(charSequence.charAt(charSequence.length() - 1)));
                    keyhighlight.add(String.valueOf(charSequence.charAt(charSequence.length()-1)));
                    adapter.notifyDataSetChanged();
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
