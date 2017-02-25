package com.example.lenovo.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    private EditText  editText;
    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.editText1);
        outputText= (TextView) findViewById(R.id.textView1);
        outputText.setMovementMethod(ScrollingMovementMethod.getInstance());

    }

    public void downloadUrl(View view) {
        String url="http://"+editText.getText().toString();
        OkHttpHandler handler = new OkHttpHandler();
        String result=null;
        try {
            result= (String) handler.execute(url).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        outputText.append(result+"\n");

    }


}


