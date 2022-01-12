package com.example.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.VH> {
    private ArrayList<Model>arrayList;
    private Context context;

    public Adapter(ArrayList<Model> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_dashboard,viewGroup,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        //Picasso.with(context).load(arrayList.get(i).getImage()).error(R.drawable.ic_launcher_foreground).into(vh.imageView);
        vh.textView.setText(arrayList.get(i).getName());
        vh.imageView.setImageResource(arrayList.get(i).getImage());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public VH(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.iv);
            textView=itemView.findViewById(R.id.name);
        }
    }
}
