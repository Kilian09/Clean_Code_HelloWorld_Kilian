package com.example.clean_code_helloworld_kilian.hello;

import android.content.Intent;
import android.content.Context;

import com.example.clean_code_helloworld_kilian.app.AppMediator;
import com.example.clean_code_helloworld_kilian.app.ByeToHelloState;
import com.example.clean_code_helloworld_kilian.app.HelloToByeState;
import com.example.clean_code_helloworld_kilian.bye.ByeActivity;

public class HelloRouter implements HelloContract.Router {

    public static String TAG = HelloRouter.class.getSimpleName();

    private AppMediator mediator;

    public HelloRouter(AppMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void navigateToByeScreen() {
        Context context = mediator.getApplicationContext();
        Intent intent = new Intent(context, ByeActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void passDataToByeScreen(HelloToByeState state) {
        mediator.setHelloToByeState(state);
    }

    @Override
    public ByeToHelloState getDataFromByeScreen() {
        if (mediator != null) {
            return mediator.getByeToHelloState();
        }
        return null;
    }
}
