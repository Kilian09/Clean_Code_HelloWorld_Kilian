package com.example.clean_code_helloworld_kilian.bye;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import com.example.clean_code_helloworld_kilian.app.AppMediator;
import com.example.clean_code_helloworld_kilian.app.ByeToHelloState;
import com.example.clean_code_helloworld_kilian.app.HelloToByeState;
import com.example.clean_code_helloworld_kilian.hello.HelloActivity;

public class ByeRouter implements ByeContract.Router {

    public static String TAG = ByeRouter.class.getSimpleName();

    private AppMediator mediator;

    public ByeRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToHelloScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, HelloActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToHelloScreen(ByeToHelloState state) {
        mediator.setByeToHelloState(state);
    }

    @Override
    public HelloToByeState getDataFromHelloScreen() {
        HelloToByeState state = mediator.getHelloToByeState();
        return state;
    }
}
