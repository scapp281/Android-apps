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
    /**
     * findViewById() once and save the views' reference for Optimizing NoteAdapter
     * */
    public static class ViewHolder{
        TextView noteTitle;
        TextView noteBody;
        ImageView noteIcon;
    }

    public NoteAdapter(Context context, ArrayList<Note> notes) {
        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //get data item at this postion
        Note note = getItem(position);

        ViewHolder viewHolder;

        //check if there an existing view can be reused, otherwise
        // inflated a new view from custon row layout
        if(convertView ==null){

            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent,false);

            //set views to view holder so that we no longer have to go back and use
            //findViewById() for every new row
            viewHolder.noteTitle = (TextView) convertView.findViewById(R.id.listItemNoteTitle);
            viewHolder.noteBody = (TextView) convertView.findViewById(R.id.listItemNoteBody);
            viewHolder.noteIcon = (ImageView) convertView.findViewById(R.id.listItemNoteImg);

            //use tag to store reference of views
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.noteTitle.setText(note.getTitle());
        viewHolder.noteBody.setText(note.getMessage());
        viewHolder.noteIcon.setImageResource(note.getAssociatedDrawable());

        return convertView;
    }
}
