package com.example.mobilecomputingbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Context mContext;

    ArrayList<String> titleArrayList;
    private RecyclerView mRecylerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;

        titleArrayList = new ArrayList<String>();

        titleArrayList.add(Constants.UNIT_ONE);
        titleArrayList.add(Constants.UNIT_TWO);
        titleArrayList.add(Constants.UNIT_THREE);
        titleArrayList.add(Constants.UNIT_FOUR);
        titleArrayList.add(Constants.UNIT_FIVE);




        mRecylerView = (RecyclerView)findViewById(R.id.recylerView);
        mRecylerView.setHasFixedSize(true);
        mRecylerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        TitleAdapter adapter = new TitleAdapter(mContext, titleArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                Intent desIntent = new Intent(mContext,DescriptionActivity.class);

                desIntent.putExtra("titles",titleArrayList.get(position));

                startActivity(desIntent);


                Toast.makeText(mContext," "+titleArrayList.get(position),Toast.LENGTH_SHORT);
            }
        });

        mRecylerView.setAdapter(adapter);
    }
}
