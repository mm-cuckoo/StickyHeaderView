package com.cfox.stickyheaderview.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cfox.stickyheaderview.R;
import com.cfox.stickyheaderview.stickyview.baseview.StickHeaderViewFragment;

import java.util.ArrayList;

/**
 * <br/>************************************************
 * <br/>PROJECT_NAME : StickyHeaderView
 * <br/>PACKAGE_NAME : com.cfox.stickyheaderview.fragment
 * <br/>AUTHOR : CFOX
 * <br/>MSG :
 * <br/>************************************************
 */
public class ListViewFragment extends StickHeaderViewFragment {

    private ListView listView;
    private String mName;

    public static ListViewFragment newInstance() {
        return new ListViewFragment();
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new MyAdapter());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "点击了条目" + position, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public View getScrollableView() {
        return listView;
    }

    public ListViewFragment setViewName(String name) {
        this.mName = name;
        return this;
    }
    @Override
    public String getViewName() {
        if (mName == null){
            mName = this.getClass().getSimpleName();
        }
        return mName;
    }

    public class MyAdapter extends BaseAdapter {

        private ArrayList<String> strings;

        public MyAdapter() {
            strings = new ArrayList<>();
            for (int i = 0; i < 40; i++) {
                strings.add("条目" + i);
            }
        }

        @Override
        public int getCount() {
            return strings.size();
        }

        @Override
        public String getItem(int position) {
            return strings.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(getActivity(), android.R.layout.simple_list_item_1, null);
            }
            TextView textView = (TextView) convertView;
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(Color.WHITE);
            ViewGroup.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300);
            textView.setLayoutParams(params);
            textView.setText(getItem(position));
            textView.setBackgroundColor(Utils.generateBeautifulColor());
            return convertView;
        }
    }
}
