package geekfest.com.byldafarm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class SplashScreen extends Activity {
    ImageView imageSplash;
    int width, height;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.RGBA_8888);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splashscreen);
        Display display = getWindowManager().getDefaultDisplay();
        width = display.getWidth();
        height = display.getHeight();
        imageSplash = (ImageView)findViewById(R.id.imageSplash);
        imageSplash.setVisibility(View.INVISIBLE);
        AnimationSet as = new AnimationSet(true);
        Animation aa = new ScaleAnimation((float)0.6
                , (float)0.5, (float)0.6, (float)0.5
                , width / 2
                , height / 2);
        aa.setDuration(2000);
        aa.setStartOffset(1000);
        as.addAnimation(aa);
        aa = new AlphaAnimation(0, 1);
        aa.setDuration(2000);
        aa.setStartOffset(1000);
        as.addAnimation(aa);
        as.setFillEnabled(true);
        as.setFillAfter(true);
        as.setInterpolator(new DecelerateInterpolator());
        as.setStartTime(1000);
        imageSplash.startAnimation(as);
        imageSplash.setVisibility(View.VISIBLE);
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent go = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(go);
                SplashScreen.this.finish();
            }
        };
        new Thread(runnable).start();
    }
}