package com.example.mybrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnGo;
    WebView webview;
    EditText txtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAddress = findViewById(R.id.adress);
        btnGo = findViewById(R.id.go);
        webview = findViewById(R.id.webview);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webview.loadUrl("http://" + txtAddress.getText());
            }
        });

        /////////////////
        if (getIntent() != null && getIntent().getData() != null){
            txtAddress.setText(getIntent().getData().toString());
            webview.loadUrl(getIntent().getData().toString());
        }
        //////////
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

}