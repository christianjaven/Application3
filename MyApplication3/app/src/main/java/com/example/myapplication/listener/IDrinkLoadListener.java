package com.example.myapplication.listener;

import java.util.List;


import com.example.myapplication.model.DrinkModel;


public interface IDrinkLoadListener {
    void onDrinkLoadSuccess(List<DrinkModel> drinkModelList);
    void onDrinkLoadFailed(String message);
}
