package com.example.webview;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText etSearch;
    Button btnGo;
    WebView WebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSearch = (EditText) findViewById(R.id.etSearch);
        btnGo = (Button) findViewById(R.id.btnGo);
        WebView = (WebView) findViewById(R.id.WebView);

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnGo:
                        String url = etSearch.getText().toString();
                        WebView.getSettings().setJavaScriptEnabled(true);
                        System.out.println(url);
                        WebView.loadUrl(url);

                        break;
                }

            }
        });
    }

    
    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
