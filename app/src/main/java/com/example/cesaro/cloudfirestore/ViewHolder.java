package com.example.cesaro.cloudfirestore;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView namet,artistat,duraciont;
    public ImageView imageArt;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        namet = itemView.findViewById(R.id.title);
        artistat = itemView.findViewById(R.id.description);
        duraciont = itemView.findViewById(R.id.tiempo);
        imageArt = itemView.findViewById(R.id.image);





    }
}
