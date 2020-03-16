package com.example.clean_code_helloworld_kilian.hello;

import android.util.Log;

public class HelloModel implements HelloContract.Model {

    private String message;

    public static String TAG = HelloModel.class.getSimpleName();

    public HelloModel(String message) {
        this.message = message; //msg = "Hello world!"
    }

    @Override
    public String getHelloMessage() {
        // Log.e(TAG, "getByeMessage()");
        return message;
    }
}
