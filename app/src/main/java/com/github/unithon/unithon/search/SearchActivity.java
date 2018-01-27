package com.github.unithon.unithon.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.SearchInfo;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity{
    //카드 클릭시 -> bookActivity로
    //Search View
    EditText editText;
    Button searchButton;
    Button XButton;

    //RecyclerView
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    // 아이템 리스트
    //private String[] myDataset;
    private static ArrayList<SearchInfo> searchinfoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        editText = (EditText)findViewById(R.id.SearchText);
        searchButton = (Button)findViewById(R.id.SearchButton);
        XButton = (Button)findViewById(R.id.Xbutton);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //값은 여기로 날릴거임 
                String SearchValue = editText.getText().toString();
                Toast.makeText(getApplicationContext(),SearchValue,Toast.LENGTH_LONG).show();
            }
        });

        XButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");
            }
        });

        //searchView = (SearchView) R.id.search_box;

        //Recycler View
        //데이터준비-실제로는 ArrayList<>등을 사용해야 할듯 하다.
        //인터넷이나 폰에 있는 DB에서 아이템을 가져와 배열에 담아 주면 된다.
        //myDataset = new String[]{"도봉순", "이순신", "강감찬","세종대왕"};
        //ArrayList 생성

        searchinfoList = new ArrayList<>();
        //ArrayList에 값 추가하기
        searchinfoList.add(new SearchInfo("마음의 바다", "홍길동", 1));
        searchinfoList.add(new SearchInfo("마음의 바다2", "홍길동", 1));
        searchinfoList.add(new SearchInfo("마음의 바다3", "홍길동", 1));
        searchinfoList.add(new SearchInfo("마음의 바다4", "홍길동", 1));
        searchinfoList.add(new SearchInfo("마음의 바다5", "홍길동", 1));
        searchinfoList.add(new SearchInfo("마음의 바다6", "홍길동", 1));

        mRecyclerView = (RecyclerView) findViewById(R.id.search_recycler_view);
        mRecyclerView.setHasFixedSize(true);//옵션
        //Linear layout manager 사용
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //어답터 세팅
        mAdapter = new SearchAdapter(searchinfoList); //스트링 배열 데이터 인자로
        mRecyclerView.setAdapter(mAdapter);
    }
}