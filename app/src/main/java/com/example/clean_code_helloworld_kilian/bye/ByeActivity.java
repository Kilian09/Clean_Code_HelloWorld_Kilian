package com.example.clean_code_helloworld_kilian.bye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.clean_code_helloworld_kilian.R;

public class ByeActivity
        extends AppCompatActivity implements ByeContract.View {

    public static String TAG = ByeActivity.class.getSimpleName();

    private ByeContract.Presenter presenter;

    Button sayByeButton, goHelloButton;
    TextView byeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bye);

        getSupportActionBar().setTitle(R.string.bye_screen_title);

        goHelloButton = findViewById(R.id.goHelloButton);
        sayByeButton = findViewById(R.id.sayByeButton);
        byeMessage = findViewById(R.id.byeMessage);

        sayByeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.sayByeButtonClicked();
            }
        });

        goHelloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goHelloButtonClicked();
            }
        });

        sayByeButton.setText(getSayByeButtonLabel());
        goHelloButton.setText(getGoHelloButtonLabel());

        // do the setup
        ByeScreen.configure(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResumeCalled();
    }

    @Override
    public void injectPresenter(ByeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayByeData(ByeViewModel viewModel) {
        //Log.e(TAG, "displayHelloData()");

        // deal with the data
        byeMessage.setText(viewModel.byeMessage);
    }

    private String getGoHelloButtonLabel() {
        return getResources().getString(R.string.say_bye_button_label);
    }

    private String getSayByeButtonLabel() {
        return getResources().getString(R.string.go_hello_button_label);
    }
}
