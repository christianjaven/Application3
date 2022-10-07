package com.example.myapplication.listener;

import com.example.myapplication.model.CartModel;
import com.example.myapplication.model.DrinkModel;

import java.util.List;

public interface ICartLoadListener {
    void onCartLoadSuccess(List<CartModel> cartModelList);
    void onCartLoadFailed(String message);
}
