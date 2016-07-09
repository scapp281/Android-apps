package com.scapp.androidvocabulary.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.scapp.androidvocabulary.CardFlipAnimation;
import com.scapp.androidvocabulary.R;
import com.scapp.androidvocabulary.adapter.ListAdapter;
import com.scapp.androidvocabulary.model.ListData;

public class MainActivity extends AppCompatActivity implements ListAdapter.ClickListener {

    private RecyclerView recyclerView;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rec_list);
        //Check out GridLayoutManager and StaggeredGridLayoutManager for more options
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        listAdapter = new ListAdapter(ListData.getListData(), this);
        listAdapter.setClickListener(this);
        recyclerView.setAdapter(listAdapter);
    }

    public void onCardClick(View view) {
        flipCard();
    }

    private void flipCard() {
        View rootLayout = findViewById(R.id.main_activity_root);
        View cardFace = findViewById(R.id.main_activity_card_face);
        View cardBack = findViewById(R.id.gistL);

        CardFlipAnimation flipAnimation = new CardFlipAnimation(cardFace, cardBack);

        if (cardFace.getVisibility() == View.GONE) {
            flipAnimation.reverse();
        }
        rootLayout.startAnimation(flipAnimation);
    }

    /*
    * call when item click and do flip animation
    */
    @Override
    public void itemClick(View view, int position) {
        View rootLayout = findViewById(R.id.main_activity_root);
        View cardFace = findViewById(R.id.main_activity_card_face);
        View cardBack = findViewById(R.id.viewL);
        switch (position) {
            case 0:
                cardBack = findViewById(R.id.viewL);
                break;
            case 1:
                cardBack = findViewById(R.id.viewgroupL);
                break;
            case 2:
                cardBack = findViewById(R.id.relativeL);
                break;
            case 3:
                cardBack = findViewById(R.id.linearL);
                break;
            case 4:
                cardBack = findViewById(R.id.recycleviewL);
                break;
            case 5:
                cardBack = findViewById(R.id.onclickL);
                break;
        }
        CardFlipAnimation flipAnimation = new CardFlipAnimation(cardFace, cardBack);
        if (cardFace.getVisibility() == View.GONE) {
            flipAnimation.reverse();
        }
        rootLayout.startAnimation(flipAnimation);
    }
}
