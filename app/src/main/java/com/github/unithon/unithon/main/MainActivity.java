package com.github.unithon.unithon.main;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.search.SearchActivity;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.navigation)
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {
            case R.id.navigation_home:


                return true;
            case R.id.navigation_search:
                final Intent intent = new Intent(this, SearchActivity.class);
                startActivity(intent);

                return true;
            case R.id.navigation_mypage:

                return true;
            default:
                return false;
        }

    }

}
