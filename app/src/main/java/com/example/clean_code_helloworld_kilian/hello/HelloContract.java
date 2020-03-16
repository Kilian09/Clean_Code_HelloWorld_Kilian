package com.example.clean_code_helloworld_kilian.hello;

import com.example.clean_code_helloworld_kilian.app.ByeToHelloState;
import com.example.clean_code_helloworld_kilian.app.HelloToByeState;

import java.lang.ref.WeakReference;

public interface HelloContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayHelloData(HelloViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onResumeCalled();

        void sayHelloButtonClicked();

        void goByeButtonClicked();
    }

    interface Model {

        String getHelloMessage();
    }

    interface Router {
        void navigateToByeScreen();

        void passDataToByeScreen(HelloToByeState state);

        ByeToHelloState getDataFromByeScreen();
    }
}
