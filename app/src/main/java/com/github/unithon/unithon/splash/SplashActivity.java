package com.github.unithon.unithon.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.unithon.unithon.main.MainActivity;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.util.PollyHelper;

public class SplashActivity extends AppCompatActivity {

    private static final int DELAY = 1000;

    private static final boolean DEBUG_MAIN = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        PollyHelper.getInstance().playPolly("여러분 우리 앱 잘만들어서 1등해요 하핳");

        new Handler().postDelayed(() -> {
            if(DEBUG_MAIN) {
                final Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, DELAY);
    }
}
