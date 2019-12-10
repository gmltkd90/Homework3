package com.cpsc411.homework_2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.widget.ListView;
import android.view.Menu;


import androidx.annotation.Nullable;

import com.cpsc411.homework_2.adapter.SummaryListAdapter;
import com.cpsc411.homework_2.model.Student;

import java.util.ArrayList;

public class SummaryLVActivity extends Activity {

    ListView mSummaryView;
    protected  SummaryListAdapter ad;
    protected  final String TAG = "Summary Screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"onCreate() called");
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.student_list_lv);
        //
        mSummaryView = findViewById(R.id.summary_list_id);
        ad = new SummaryListAdapter();//this is the adapter pattern
        mSummaryView.setAdapter(ad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Custom Menu inflation
        //getMenuInflater().inflate(R.menu.summary_screen_menu, menu);
        //menu.findItem(R.id.action_add).setVisible(true);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.summary_screen_menu, menu);
        return true;
    }

    @Override
    protected void onStart() {
        Log.d(TAG,"onStart() called");
        ad.notifyDataSetChanged();
        super.onStart();
    }


    @Override
    protected void onResume() {
        Log.d(TAG,"onResume() called");
        super.onResume();
    }


    @Override
    protected void onPause() {
        Log.d(TAG,"onPause() called");
        super.onPause();
    }


    @Override
    protected void onStop() {
        Log.d(TAG,"onStop() called");
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        Log.d(TAG,"onDestroy() called");
        super.onDestroy();
    }
}
