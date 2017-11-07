package com.farzad119.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Farzad on 11/7/2017.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOTER_ONE = 2;
    private static final int TYPE_FOOTER_TWO = 3;
    private final Context context;
    private final ArrayList arrayList;
    private Model model;

    public Adapter(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        Log.wtf("constractor ", "arrayList size : " + arrayList.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header, parent, false);
            return new ViewHolderHeader(v);
        }else if (viewType == TYPE_ITEM){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new ViewHolderItem(v);
        }else if(viewType == TYPE_FOOTER_ONE){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer_one, parent, false);
            return new ViewHolderFooterOne(v);
        }else if(viewType == TYPE_FOOTER_TWO){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer_two, parent, false);
            return new ViewHolderFooterTwo(v);
        }else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        if (viewHolder instanceof Adapter.ViewHolderItem) {
            model = (Model) arrayList.get(position-2);
            ((ViewHolderItem) viewHolder).txtName.setText(model.getName());
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else if (position == 1) {
            return TYPE_FOOTER_ONE;
        } else if (position > arrayList.size()+1 ) {
            return TYPE_FOOTER_TWO;
        } else {
            return TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size() + 3;
    }

    public static class ViewHolderHeader extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView imgIcon;

        public ViewHolderHeader(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            imgIcon = itemView.findViewById(R.id.imgIcon);
        }
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder {
        TextView txtName;

        public ViewHolderItem(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
        }
    }

    public static class ViewHolderFooterOne extends RecyclerView.ViewHolder {
        TextView txtTitle;

        public ViewHolderFooterOne(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
        }
    }

    public static class ViewHolderFooterTwo extends RecyclerView.ViewHolder {
        TextView txtTitle;

        public ViewHolderFooterTwo(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
        }
    }

}
