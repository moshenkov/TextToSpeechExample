package com.example.android.texttospeechexample;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    private TextToSpeech ttobj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

        ttobj = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR) {
                    ttobj.setLanguage(Locale.getDefault());
                }
            }
        });
    }

    public void onClick(View view) {
        String text = editText.getText().toString();
        ttobj.speak(text, TextToSpeech.QUEUE_FLUSH, null);

    }

    @Override
    protected void onPause() {
        if(ttobj !=null){
            ttobj.stop();
            ttobj.shutdown();
        }

        super.onPause();
    }
}
