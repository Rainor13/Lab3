package es.udc.psi.lab3touris;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends GlobalActivity implements ItemClickListener  {

    @BindView(R.id.rv) RecyclerView recyclerView;

    private static final String TAG = "ItemActivity";
    ArrayList<Model> modelList = new ArrayList<>();
    private CategoriesAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 3; i++) {
            Model model = new Model(null, null, null);
            model.setTitle("Titulon "+ i);
            model.setSubTitle("SubTitulon "+ i);
            model.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.");
            modelList.add(model);
        }

        mAdapter = new CategoriesAdapter(modelList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);

        View.OnClickListener onItemClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View view){
                RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
                int position = viewHolder.getAdapterPosition();
                Model thisItem = modelList.get(position);
                Toast.makeText(MainActivity.this,"You cliked: " + thisItem,Toast.LENGTH_SHORT).show();
            }
        };

    }

    @Override
    public void onItemClick(View view, int position) {

        Model model = modelList.get(position);
        Intent intent = new Intent(this, Peliculon.class);
        intent.putExtra("Titulon", model.getTitle());
        intent.putExtra("SubTitulon", model.getSubTitle());
        intent.putExtra("Descripcion", model.getDescription());
        startActivity(intent);

    }
}