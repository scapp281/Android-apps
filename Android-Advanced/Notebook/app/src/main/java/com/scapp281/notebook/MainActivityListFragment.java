package com.scapp281.notebook;


import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivityListFragment extends ListFragment {

    private ArrayList<Note> notes;
    private NoteAdapter noteAdapter;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<Note> notes = new ArrayList<Note>();
        notes.add(new Note("Hello Android","This is a new note body", Category.MAP));
        notes.add(new Note("Hello Android","This is a new note body", Category.MAP));
        noteAdapter = new NoteAdapter(getActivity(),notes);
        setListAdapter(noteAdapter);

        getListView().setDivider(ContextCompat.getDrawable(getActivity(), android.R.color.holo_green_light));
        getListView().setDividerHeight(10);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }

}
