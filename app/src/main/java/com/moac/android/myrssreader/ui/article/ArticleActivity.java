package com.moac.android.myrssreader.ui.article;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.moac.android.myrssreader.R;

public class ArticleActivity extends AppCompatActivity {

    private static final String ARTICLE_URL = "ARTICLE_URL";

    public static void launch(Context context, String articleUrl) {
        Intent intent = new Intent(context, ArticleActivity.class);
        intent.putExtra(ARTICLE_URL, articleUrl);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        // Retrieve the Article URL from the Intent parameters
        String url = getIntent().getStringExtra(ARTICLE_URL);

        // Load the URL into the WebView
        WebView webView = (WebView) findViewById(R.id.webview_article);
        webView.loadUrl(url);
    }
}
