package com.example.my_parking.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_parking.R;
import com.example.my_parking.storage.FirebaseRepo;
import com.example.my_parking.view.MyViewHolder;


public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private FirebaseRepo firebaseRepo;

    public MyAdapter(FirebaseRepo firebaseRepo) {
        this.firebaseRepo = firebaseRepo;
    }

    @NonNull
    @Override   // Parent is "this" of main activity
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(
                parent.getContext()).inflate(R.layout.mylayout, parent, false);
        return new MyViewHolder(linearLayout); // Pass the linearLayout as a constructor arg. to MyViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setData(firebaseRepo.favorites.get(position).getTitle(),
                firebaseRepo.favorites.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return firebaseRepo.favorites.size(); // Start with dummy number of items
    }


}
