package com.example.lenovo.okhttp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    Button downloadBtn;
    ImageView mImage;
    private final String URL="http://paper.people.com.cn/rmrb/res/1/20170225/1487964657205_1.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadBtn= (Button) findViewById(R.id.button1);
        mImage= (ImageView) findViewById(R.id.imageView1);

        downloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadBtn.setVisibility(View.INVISIBLE);
                OkHttpHandler handler=new OkHttpHandler();
                byte[] image=new byte[0];
                try {
                    image= (byte[]) handler.execute(URL).get();
                    if(image != null && image.length>0){
                        Bitmap bitmap= BitmapFactory.decodeByteArray(image,0,image.length);
                        mImage.setImageBitmap(bitmap);
                        mImage.setVisibility(View.VISIBLE);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
