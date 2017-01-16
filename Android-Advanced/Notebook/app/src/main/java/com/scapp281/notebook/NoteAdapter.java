package com.scapp281.notebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends ArrayAdapter<Note> {
    public NoteAdapter(Context context, ArrayList<Note> notes) {
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //get data item at this postion
        Note note = getItem(position);

        //check if there an existing view can be reused, otherwise
        // inflated a new view from custon row layout
        if(convertView ==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent,false);
        }

        TextView noteTitle = (TextView) convertView.findViewById(R.id.listItemNoteTitle);
        TextView noteBody = (TextView) convertView.findViewById(R.id.listItemNoteBody);
        ImageView noteIcon = (ImageView) convertView.findViewById(R.id.listItemNoteImg);

        noteTitle.setText(note.getTitle());
        noteBody.setText(note.getMessage());
        noteIcon.setImageResource(note.getAssociatedDrawable());

        return convertView;
    }
}
