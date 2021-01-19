package com.salmaapp.tp32;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {
  String  s2[],index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();

         s2=getResources().getStringArray(R.array.description);
         index =intent.getStringExtra("index");
        int i = Integer.parseInt(index) ;
        TextView textView =findViewById(R.id.textView2);
        textView.setText(s2[i]);
        ImageView image = findViewById(R.id.image);
        if (i==0)
       image.setImageResource(R.drawable.spaghetti);
        else if(i==1) image.setImageResource(R.drawable.saucebroccli);
        else if(i==2) image.setImageResource(R.drawable.pizza);
        else if(i==3) image.setImageResource(R.drawable.cordonbleu);
        else if(i==4) image.setImageResource(R.drawable.escalopepane);

    }
}