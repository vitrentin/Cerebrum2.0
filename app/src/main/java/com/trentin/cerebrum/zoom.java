package com.trentin.cerebrum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class zoom extends AppCompatActivity {
    private String texto;
    private int img;
    private TextView textView;
    private ImageView imageView;
    private Button voltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);
        texto = getIntent().getStringExtra("texto");
        img = getIntent().getIntExtra("img",0);
        textView = findViewById(R.id.textzoom);
        textView.setText(texto);
        imageView = findViewById(R.id.imgzoom);
        Drawable drawable = getResources().getDrawable(img);
        imageView.setImageDrawable(drawable);
        voltar = findViewById(R.id.voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(zoom.this, Tela2.class);
                intent.putExtra("img",img);
                intent.putExtra("texto",texto);
                finish();
            }

        });
    }
}