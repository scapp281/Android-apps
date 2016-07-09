package com.scapp.androidvocabulary.model;

import java.util.ArrayList;
import java.util.List;

/*
* Populate data list as mock data for our RecyclerView
*/
public class ListData {
    private static final String[] titles = {"View", "ViewGroup",
            "RelativeLayout", "LinearLayout", "RecyclerView","OnClickListener","Gist"};

    private static final int[] icons = {

            android.R.drawable.ic_menu_add, android.R.drawable.ic_menu_delete,
            android.R.drawable.ic_input_get, android.R.drawable.ic_menu_agenda,android.R.drawable.ic_lock_lock,android.R.drawable.ic_lock_power_off};

    public static List<ListItem> getListData() {
        List<ListItem> data = new ArrayList<>();

        //Repeat process x times, so that we have enough data to demonstrate a scrollable RecyclerView
        for (int x = 0; x < 1; x++) {
            //create ListItem with dummy data, then add them to our List
            for (int i = 0; i < titles.length && i < icons.length; i++) {
                ListItem item = new ListItem();
                item.setImageResId(icons[i%icons.length]);
                item.setTitle(titles[i%titles.length]);
                data.add(item);
            }
        }
        return data;
    }
}
