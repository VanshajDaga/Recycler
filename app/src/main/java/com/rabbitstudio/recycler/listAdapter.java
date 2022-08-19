package com.rabbitstudio.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class listAdapter extends RecyclerView.Adapter<listAdapter.ViewHolder> {
    //private ArrayList<list_Items> list_items;
    private ArrayList<String> product_name;
    private ArrayList<Integer> quantity;
    private ArrayList<Double> price;
    private ArrayList<String> specs;
    private static Context scontext;

    public listAdapter(Context context)
    {
        scontext = context;
        this.product_name = new ArrayList<String>();
        this.price = new ArrayList<Double>();
        this.quantity = new ArrayList<Integer>();
        this.specs = new ArrayList<String>();
    }

    public listAdapter(Context context, ArrayList<String> pdname, ArrayList<Integer> quantity, ArrayList<Double> price, ArrayList<String> specs)
    {
        this.product_name = pdname;
        this.price = price;
        this.quantity = quantity;
        this.specs = specs;
        scontext = context;
    }

    @NonNull
    @Override
    public listAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.productview,parent,false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull listAdapter.ViewHolder holder, int position) {
        holder.actv.setText(product_name.get(position));
        holder.qty.setText(quantity.get(position).toString());
        holder.price.setText(price.get(position).toString());
        holder.desc.setText(specs.get(position));

/*
        holder.
        holder.lvlbkg.setImageResource(temp);
        holder.pb.setProgress(listitem.getProgress());

        holder.frameLayout.setTag(position);*/
    }
    public void addView(String pdname, Double prc, Integer quant, String spec ) {

        product_name.add(pdname);
        quantity.add(quant);
        price.add(prc);
        specs.add(spec);
        notifyItemInserted(product_name.size());
        notifyItemInserted(quantity.size());
        notifyItemInserted(price.size());
        notifyItemInserted(specs.size());
    }

    public void removeAt(int position) {

        product_name.remove(position);
        quantity.remove(position);
        price.remove(position);
        specs.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, product_name.size());
        notifyItemRangeChanged(position, quantity.size());
        notifyItemRangeChanged(position, price.size());
        notifyItemRangeChanged(position, specs.size());
    }

    @Override
    public int getItemCount() {
        return product_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public AutoCompleteTextView actv;
        public EditText qty;
        public EditText price;
        public EditText desc;
        public Button button;
        public ViewHolder(View itemView) {
            super(itemView);
            this.actv = itemView.findViewById(R.id.tv_product);
            this.qty = itemView.findViewById(R.id.prod_qty);
            this.price = itemView.findViewById(R.id.prod_price);
            this.desc = itemView.findViewById(R.id.prod_specs);
            this.button = itemView.findViewById(R.id.btn_rmv);
            button.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if(v.equals(button)){
                removeAt(getAdapterPosition());
        }

        }
    }
}
