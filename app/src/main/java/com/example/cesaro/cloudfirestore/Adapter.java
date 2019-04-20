package com.example.cesaro.cloudfirestore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {


    RecyclerViewActivity mainActivity;
    ArrayList<Disco> discos;
    Context context;

    public Adapter(RecyclerViewActivity mainActivity, ArrayList<Disco> discos) {
        this.mainActivity = mainActivity;
        this.discos = discos;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(mainActivity.getBaseContext());
        View view = layoutInflater.inflate(R.layout.row, viewGroup, false);
        context = viewGroup.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {


        viewHolder.namet.setText(discos.get(i).getNameA());
        viewHolder.artistat.setText(discos.get(i).getDuracionA());
        viewHolder.duraciont.setText(discos.get(i).getArtistaA());

        if (discos.get(i).getUrlImage()!=null){
            Glide.with(context)
                    .load(discos.get(i).getUrlImage())
                    .into(viewHolder.imageArt);
        }

    }

    @Override
    public int getItemCount() {
        return discos.size();
    }
}
