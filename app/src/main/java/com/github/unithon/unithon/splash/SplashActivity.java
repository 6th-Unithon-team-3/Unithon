package com.github.unithon.unithon.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.github.unithon.unithon.main.MainActivity;
import com.github.unithon.unithon.R;

public class SplashActivity extends AppCompatActivity {

    private static final boolean DEBUG_MAIN = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(DEBUG_MAIN) {
                    final Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, 2000);
    }
}
