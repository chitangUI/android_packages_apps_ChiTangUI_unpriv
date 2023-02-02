package chitangui.chitangui_unpriv.fun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.TextView;

public class FunActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout layout = new FrameLayout(this);
        setContentView(layout);

        {
            WebView webView = new WebView(this);
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    setResult(1);
                    finish();
                    return true;
                }
            });
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("file:android_asset/fun.html");

            layout.addView(webView);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            setResult(2);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}
