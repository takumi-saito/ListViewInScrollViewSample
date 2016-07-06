package com.example.saito.listviewinscrollviewsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.ScrollingTabContainerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListAdapter mListAdapter;
    MesuredListView mMesuredListView;
    List<String> mValues;
    ScrollView mScrollView;
    boolean initFlg = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mMesuredListView = (MesuredListView) findViewById(R.id.list);

        mValues = new ArrayList<String>();
        for (int i = 1; i < 51; i++) {
            mValues.add("hogehoge:" + i);
        }

        mListAdapter = new ListAdapter(this, R.layout.item_listview, mValues);

        for (int i = 0; i < mValues.size(); i++) {
            mListAdapter.add(mValues.get(i));
        }
        mMesuredListView.setAdapter(mListAdapter);
        mListAdapter.refreshItemList(mValues);

        mScrollView = (ScrollView) findViewById(R.id.scroll);
        Log.v("saito", "onCreate getScrollX:" + mScrollView.getScrollX()+ " " + "getScrollY:" + mScrollView.getScrollY());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mListAdapter.refreshItemList(mValues);
        Log.v("saito", "onCreate getScrollX:" + mScrollView.getScrollX()+ " " + "getScrollY:" + mScrollView.getScrollY());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mListAdapter.refreshItemList(mValues);
        Log.v("saito", "onResume getScrollX:" + mScrollView.getScrollX()+ " " + "getScrollY:" + mScrollView.getScrollY());
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.v("saito", "onWindowFocusChanged getScrollX:" + mScrollView.getScrollX()+ " " + "getScrollY:" + mScrollView.getScrollY());
        if (initFlg) {
            mScrollView.setScrollY(0);
        }
        initFlg = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("saito", "onPause getScrollX:" + mScrollView.getScrollX()+ " " + "getScrollY:" + mScrollView.getScrollY());
    }
}
