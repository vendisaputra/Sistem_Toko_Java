package com.example.company.appstore;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAbsensiAdapter extends RecyclerView.Adapter<ListAbsensiAdapter.MyViewHolder> {

    Context context;
    ArrayList<ListAbsensiConst> labsensiConsts;
    public ListAbsensiAdapter(ArrayList<ListAbsensiConst> p, Context c){
        labsensiConsts = p;
        context = c;
    }

    @NonNull
    @Override
    public ListAbsensiAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ListAbsensiAdapter.MyViewHolder(LayoutInflater.
                from(context).inflate(R.layout.item_list_absensi,
                viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListAbsensiAdapter.MyViewHolder myViewHolder, int i) {

        myViewHolder.xtgl.setText(labsensiConsts.get(i).getTanggal());
        myViewHolder.xboxhadir.setText(labsensiConsts.get(i).getKeterangan());

    }

    @Override
    public int getItemCount() {
        return labsensiConsts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView xtgl,  xboxhadir;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            xtgl = itemView.findViewById(R.id.xtgl);
            xboxhadir = itemView.findViewById(R.id.xboxhadir);

        }
    }

}
