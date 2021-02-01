package com.example.telalogin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentViewHolder;

import java.util.ArrayList;

public class AdapterProduto extends  RecyclerView.Adapter<AdapterProduto.MyProduto>{

    ArrayList<String> produtos;



    public AdapterProduto(ArrayList<String> produtos) {
        this.produtos = produtos;
    }




    @NonNull
    @Override
    public MyProduto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main7, parent, false);
                return new MyProduto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyProduto holder, int position) {
        holder.ListText.setText(produtos.get(position));
        holder.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public class MyProduto extends RecyclerView.ViewHolder{
        public TextView ListText;
        public Button bt;
        public MyProduto(@NonNull View itemView) {
            super(itemView);
            ListText = itemView.findViewById(R.id.ListText);
            bt = itemView.findViewById(R.id.bt);
        }
    }

}
