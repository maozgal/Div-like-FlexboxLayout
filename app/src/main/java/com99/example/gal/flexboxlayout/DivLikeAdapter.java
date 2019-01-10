package com99.example.gal.flexboxlayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class DivLikeAdapter extends RecyclerView.Adapter<DivLikeAdapter.DivItemViewHolder> {
    private ArrayList<String> mItems;

    public DivLikeAdapter(ArrayList<String> items) {
        mItems = items;
    }

    @NonNull
    @Override
    public DivLikeAdapter.DivItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new DivItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DivItemViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    public class DivItemViewHolder extends RecyclerView.ViewHolder {
        private TextView text;

        private DivItemViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }

        private void onBind(int position) {
            text.setText(mItems.get(position));
        }
    }
}