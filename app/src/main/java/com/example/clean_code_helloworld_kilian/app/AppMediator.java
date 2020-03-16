package com.example.clean_code_helloworld_kilian.app;

import android.app.Application;

import com.example.clean_code_helloworld_kilian.bye.ByeState;
import com.example.clean_code_helloworld_kilian.hello.HelloState;

public class AppMediator extends Application {

    private HelloState helloState = new HelloState();
    private ByeState byeState = new ByeState();

    private HelloToByeState helloToByeState;
    private ByeToHelloState byeToHelloState;

    public HelloState getHelloState() { return helloState; }

    public void setHelloState(HelloState state) {
        this.helloState = state;
    }

    public HelloToByeState getHelloToByeState(){
        HelloToByeState state = helloToByeState;
        helloToByeState = null;
        return state;
    }

    public void setHelloToByeState(HelloToByeState state){
        this.helloToByeState = state;
    }

    public ByeToHelloState getByeToHelloState(){
        ByeToHelloState state = byeToHelloState;
        byeToHelloState = null;
        return state;
    }

    public void setByeToHelloState(ByeToHelloState state){
        this.byeToHelloState = state;
    }

    public ByeState getByeState() { return byeState; }

    public void setByeState(ByeState state) {
        this.byeState = state;
    }
}
