package com.yanus.chucknorrisjokes;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerListCategoryAdapter extends RecyclerView.Adapter<RecyclerListCategoryAdapter.CategoryViewHolder> {

    Activity context;
    ArrayList<String> arrayList;
    OnNoteListener onNoteListener;

    public RecyclerListCategoryAdapter(Activity context, ArrayList<String> userArrayList, OnNoteListener onNoteListener) {
        this.context = context;
        this.arrayList = userArrayList;
        this.onNoteListener = onNoteListener;
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new CategoryViewHolder(rootView, onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.txtViewCategory.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtViewCategory;
        OnNoteListener onNoteListener;

        public CategoryViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            txtViewCategory = itemView.findViewById(R.id.textCategory);
            itemView.setOnClickListener(this);
            this.onNoteListener = onNoteListener;
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(arrayList.get(getAdapterPosition()));
        }
    }

    public interface OnNoteListener{
        void onNoteClick(String category);
    }
}
