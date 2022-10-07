package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.RelativeLayout;

import com.example.myapplication.listener.ICartLoadListener;
import com.example.myapplication.listener.IDrinkLoadListener;
import com.example.myapplication.model.CartModel;
import com.example.myapplication.model.DrinkModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclar_drink)
    RecyclerView recyclarDrink;
    @BindView(R.id.mainLayout)
    RelativeLayout mainLayout;
    @BindView(R.id.badge)
    NotificationBadge badge;
    @BindView(R.id.btnCart)
    FrameLayout btnCart;

    IDrinkLoadListener drinkLoadListener;
    ICartLoadListener cartLoadListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        loadDrinkFromFirebase();


    }

    private void loadDrinkFromFirebase() {
        List<DrinkModel> drinkModels = new ArrayList<>();
        FirebaseDatabase.getInstance()
                .getReference(path:"Drink")
                .addListenerForSingleValueEvent(new ValueEventListener); {

            @Override
            public void onDataChange (@NonNull Datasnapshot snapshot){
                if(snapshot.exists())
                {
                    for(DataSnapshot drinkSnapshot:snapshot.getChildren())
                    {
                        DrinkModel drinkModel = drinkModel.getValue(DrinkModel.class);
                        drinkModel.setKey(drinkSnapshot.getKey());
                        drinkModels.add(drinkModel);
                    }
                    drinkLoadListener.onDrinkLoadSuccess(drinkModels);
                }
                else
                    drinkLoadListener.onDrinkLoadFailed("Can't find drink");
            }

            @Override
            public void onCancelled (@NonNull DatabaseError error){
                drinkLoadListener.onDrinkLoadFailed(error.getMessage());

            }
        });
    }

    private void init() {
        ButterKnife.bind(target:this);


        drinkLoadListener = this;
        cartLoadListener = this;


        GridLayout gridLayout = new GridLayout(context: this,spanCount: 2);
        recyclarDrink.setLayoutManager(gridLayoutManager);
        recyclarDrink.addItemDecoration(new SpaceItem());
    }

    @Override
    public void OnDrinkLoadSuccess(List<DrinkModel> drinkModelList) {
        MyDrinkAdapter adapter = new MyDrinkAdapter(this,drinkModelList);
        recyclarDrink.setAdapter(adapter);
    }

    @Override
    public void onDrinkLoadFailed(String message) {
        Snackbar.make(mainLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onCartLoadSuccess(List<CartModel> cartModelList) {

    }
}