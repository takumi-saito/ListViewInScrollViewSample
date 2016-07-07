package com.example.saito.listviewinscrollviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListAdapter mListAdapter;
    private ListView mListView;
    private List<String> mValues;
    private View mHeader;
    private View mFooter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mListView = (ListView) findViewById(R.id.list);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Toast.makeText(getBaseContext(), "position:" + position, Toast.LENGTH_SHORT).show();

                 if (position == 0) {
                     // header
                     return;
                 }
                 int itemPosition = position - 1;
                 if (itemPosition == mValues.size()) {
                     // footer
                     return;
                 }

                 // item
                 String value = mValues.get(itemPosition);
                 ((TextView) mHeader.findViewById(R.id.text_header_1)).setText(value);
                 ((TextView) mHeader.findViewById(R.id.text_header_2)).setText(value);
                 ((TextView) mHeader.findViewById(R.id.text_header_3)).setText(value);

                 ((TextView) mFooter.findViewById(R.id.text_footer_1)).setText(value);
                 ((TextView) mFooter.findViewById(R.id.text_footer_2)).setText(value);
                 ((TextView) mFooter.findViewById(R.id.text_footer_3)).setText(value);
             }
         });

        mHeader = (View) getLayoutInflater().inflate(R.layout.header_listview, null);
        mFooter = (View)getLayoutInflater().inflate(R.layout.footer_listview,null);
        mListView.addHeaderView(mHeader);
        mListView.addFooterView(mFooter);

        mValues = new ArrayList<String>();
        for (int i = 1; i < 51; i++) {
            mValues.add("hogehoge:" + i);
        }

        mListAdapter = new ListAdapter(this, R.layout.item_listview, mValues);

        for (int i = 0; i < mValues.size(); i++) {
            mListAdapter.add(mValues.get(i));
        }
        mListView.setAdapter(mListAdapter);
        mListAdapter.refreshItemList(mValues);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mListAdapter.refreshItemList(mValues);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mListAdapter.refreshItemList(mValues);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
