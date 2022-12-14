package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.example.myapplication.R;
import com.example.myapplication.model.DrinkModel;

import java.util.List;

public class MyDrinkAdapter extends RecyclerView.Adapter<MyDrinkAdapter.MyDrinkViewHolder> {

    private Context context;
    private List<DrinkModel> drinkModelList;

    public MyDrinkAdapter(Context context, List<DrinkModel> drinkModelList) {
        this.context = context;
        this.drinkModelList = drinkModelList;
    }


    @NonNull
    @Override
    public MyDrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyDrinkViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_drink_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyDrinkViewHolder holder, int position) {
        Glide.with(context)
                .load(drinkModelList.get(position).getImage())
                .into(holder.imageView)
        holder.txtPrice.setText(new StringBuilder($).append(drinkModelList.get(position).getPrice()));
        holder.txtname.setText(new StringBuilder().append(drinkModelList.get(position).getName()))

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyDrinkViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.imageView)
        Imageview imageView;
        @BindView(R.id.txtname)
        Textview txtname;
        @BindView(R.id.txtPrice)
        TextView txtPrice;

        private Unbinder unbinder;
        public MyDrinkViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(target:this,itemView);
        }
    }
}
