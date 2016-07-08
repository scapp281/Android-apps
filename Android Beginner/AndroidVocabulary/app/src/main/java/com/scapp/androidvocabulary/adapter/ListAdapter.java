package com.scapp.androidvocabulary.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.scapp.androidvocabulary.R;
import com.scapp.androidvocabulary.model.ListItem;

import java.util.List;

/*
*
* Binds data from the app with the views displayed in the list
*/
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListItem> listData;
    private LayoutInflater inflater;
    private Context context;
    private ClickListener clickListener;

    public ListAdapter(List<ListItem> listData, Context c) {
        this.context = c;
        inflater = LayoutInflater.from(c);
        this.listData = listData;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title;
        private ImageView icon;
        private View container;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.listText);
            icon = (ImageView) itemView.findViewById(R.id.listIcon);
            container = itemView.findViewById(R.id.cont_item_root);

        }

        @Override
        public void onClick(View v) {
            if(clickListener!=null){
                clickListener.itemClick(v,getAdapterPosition());
            }
        }
    }

    /*
    *  to inflate the view and its view holder
    */
    @Override
    public ViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_blueprint, parent, false);
        return new ViewHolder(view);
    }

    /*
    *  bind data to the view
    */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.icon.setImageResource(item.getImageResId());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    /*
    * Call when item click in the recycler view
    */
    public interface ClickListener{
        public void itemClick(View view, int position);
    }
    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }
}
