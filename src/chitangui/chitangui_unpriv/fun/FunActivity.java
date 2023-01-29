package chitangui.chitangui_unpriv.fun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
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
            webView.loadUrl("file:///android_assets/fun.html");
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
            webView.getSettings().setJavaScriptEnabled(true);
            webView.addJavascriptInterface(new JavaScriptInterface(), "chitangui_fun");

            layout.addView(webView);
        }
    }

    public class JavaScriptInterface {

        @JavascriptInterface
        public void poweroff() {
            finishActivity(1);
        }

    }

}
