package com.example.saito.listviewinscrollviewsample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by saito on 2016/07/07.
 */
public class ListAdapter extends ArrayAdapter<String> {
    private LayoutInflater mInflater;
    private List<String> mValues;

    public ListAdapter(Context context, int resource, List<String> values) {
        super(context, resource);

        mInflater = ((Activity) context).getLayoutInflater();
        mValues = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_listview, null);
            viewHolder = new ViewHolder();
            viewHolder.mText1 = (TextView) convertView.findViewById(R.id.text_1);
            viewHolder.mText2 = (TextView) convertView.findViewById(R.id.text_2);
            viewHolder.mText3 = (TextView) convertView.findViewById(R.id.text_3);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        String value = mValues.get(position);

        viewHolder.mText1.setText(value);
        viewHolder.mText2.setText(value);
        viewHolder.mText3.setText(value);

        return convertView;
    }

    /**
     * ListView更新
     */
    public void refreshItemList(List<String> values) {
        // 動画リスト更新
        mValues = values;
        // ビュー更新
        notifyDataSetChanged();
    }

    public static class ViewHolder {
        public TextView mText1;
        public TextView mText2;
        public TextView mText3;
    }
}