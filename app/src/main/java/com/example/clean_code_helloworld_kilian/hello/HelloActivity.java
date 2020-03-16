package com.example.clean_code_helloworld_kilian.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.clean_code_helloworld_kilian.R;

public class HelloActivity
        extends AppCompatActivity implements HelloContract.View {

    public static String TAG = HelloActivity.class.getSimpleName();

    private HelloContract.Presenter presenter;

    Button sayHelloButton, goByeButton;
    TextView helloMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        getSupportActionBar().setTitle(R.string.hello_screen_title);

        // do the setup
        HelloScreen.configure(this);

        sayHelloButton = findViewById(R.id.sayHelloButton);
        goByeButton = findViewById(R.id.goByeButton);
        helloMessage = findViewById(R.id.helloMessage);

        sayHelloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.sayHelloButtonClicked();
            }
        });

        goByeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goByeButtonClicked();
            }
        });

        sayHelloButton.setText(getSayHelloButtonLabel());
        goByeButton.setText(getGoByeButtonLabel());

        //do setup
        HelloScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load data
        presenter.onResumeCalled();
    }

    @Override
    public void injectPresenter(HelloContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayHelloData(HelloViewModel viewModel) {
        Log.e(TAG, "displayHelloData()");

        // deal with the data
        helloMessage.setText(viewModel.helloMessage);
    }

    private String getGoByeButtonLabel() {
        return getResources().getString(R.string.go_bye_button_label);
    }

    private String getSayHelloButtonLabel() {
        return getResources().getString(R.string.say_hello_button_label);
    }
}
