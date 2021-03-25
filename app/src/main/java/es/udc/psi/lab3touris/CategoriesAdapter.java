package es.udc.psi.lab3touris;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder> implements ItemClickListener{
    private ArrayList<Model> modelList;
    private ItemClickListener listener;

    @Override
    public void onItemClick(View view, int position) {

    }

    public CategoriesAdapter(ArrayList<Model> model, ItemClickListener listener) {
        this.modelList = model;
        this.listener = listener;
    }

    @Override
    public CategoriesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.tile_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(modelList.get(position), listener );
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.tile_title) public TextView titleView;
        @BindView(R.id.subtile_title) public TextView subtitleView;

        @Override
        public void onClick(View v) {
            Log.d("TAG", "CLICKAO" + getAdapterPosition());
            listener.onItemClick(v, getAdapterPosition());
        }

        public MyViewHolder(View v) {
            super(v);
            ButterKnife.bind(this,v);
            v.setOnClickListener(this);

        }

        public void bind(Model m, ItemClickListener listener) {
            titleView.setText(m.getTitle());
            subtitleView.setText(m.getSubTitle());

        }
    }

}