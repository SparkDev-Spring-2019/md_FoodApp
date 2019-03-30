package com.sparkdev.foodapp.loginscreen;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.sparkdev.foodapp.R;
import com.sparkdev.foodapp.models.Order;
import com.sparkdev.foodapp.models.OrderItem;
import com.sparkdev.foodapp.models.SingleMenuItem;
import com.sparkdev.foodapp.models.User;
import com.sparkdev.foodapp.models.firebase.FirebaseAdapter;
import com.sparkdev.foodapp.models.firebase.NewOrderCompletionListener;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private static FirebaseAdapter fb;
    private Order newOrder;
    private User currentUser;
    private OrderItem orderItem;
    private SingleMenuItem menuItem;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fb = FirebaseAdapter.getInstance(this);
        currentUser = new User("thisisanID","1234");

        menuItem = new SingleMenuItem("https://firebasestorage.googleapis.com/v0/b/foodapp-eeb94.appspot.com/o/Food%2Fcheesecake.jpg?alt=media&token=8f66127f-fe59-4f16-816d-d93af9ffc605",
                                    2.3,"cheescake");
        orderItem = new OrderItem(menuItem,5,"medium");
        ArrayList<OrderItem> orderList = new ArrayList<>();
        orderList.add(orderItem);

        newOrder = new Order("thisisanID", orderList,"2");

        fb.newOrder(newOrder, currentUser, new NewOrderCompletionListener() {
            @Override
            public void onSuccess() {
                Log.d(TAG, "order added");
            }

            @Override
            public void onFailure() {
                Log.d(TAG, "order failed to add");
            }
        });

    }

}
