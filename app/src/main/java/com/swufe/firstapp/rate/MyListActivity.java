package com.swufe.firstapp.rate;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.swufe.firstapp.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class MyListActivity extends ListActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = "";
    ListAdapter adapter;
    private int data = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        GridView listView = (GridView) findViewById(R.id.mylist);
        //init data
        for(int i = 0; i<100; i++){
            //data.add("item" + i);
        }

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setEmptyView(findViewById(R.id.nodata));
    }

    @Override
    public void onItemClick(AdapterView<?> listview, View view, int position, long id) {
        Log.i(TAG, "onItemClick: position=" + position);
        Log.i(TAG, "onItemClick: parent" + listview);
        //adapter.remove(listview.getItemAtPosition(position));
        //adapter.notifyDataSetChanged();
    }
}
