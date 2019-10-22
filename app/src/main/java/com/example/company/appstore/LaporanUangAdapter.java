package com.example.company.appstore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class LaporanUangAdapter extends RecyclerView.Adapter<LaporanUangAdapter.MyViewHolder> {

    Context context;
    ArrayList<LaporanUangConst> laporanUangConsts;
    public LaporanUangAdapter(ArrayList<LaporanUangConst> p, Context c){
        context = c;
        laporanUangConsts = p;
    }

    @NonNull
    @Override
    public LaporanUangAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new LaporanUangAdapter.MyViewHolder(LayoutInflater.
                from(context).inflate(R.layout.item_laporan_uang,
                viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LaporanUangAdapter.MyViewHolder myViewHolder, int i) {
        //currency
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

        myViewHolder.xtgl.setText(laporanUangConsts.get(i).getTanggal());

        myViewHolder.xnominal.setText(formatRupiah.format(Double.parseDouble(laporanUangConsts.get(i).getNominal())));

    }

    @Override
    public int getItemCount() {
        return laporanUangConsts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView xtgl,  xnominal;


        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            xtgl = itemView.findViewById(R.id.xtgl);
            xnominal = itemView.findViewById(R.id.xnominal);

        }
    }
}
