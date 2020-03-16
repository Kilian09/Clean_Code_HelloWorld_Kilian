package com.example.clean_code_helloworld_kilian.bye;

import com.example.clean_code_helloworld_kilian.app.ByeToHelloState;
import com.example.clean_code_helloworld_kilian.app.HelloToByeState;

import java.lang.ref.WeakReference;

public interface ByeContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void displayByeData(ByeViewModel viewModel);
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

        void injectRouter(Router router);

        void onResumeCalled();

        void sayByeButtonClicked();

        void goHelloButtonClicked();
    }

    interface Model {
        String getByeMessage();
    }

    interface Router {
        void navigateToHelloScreen();

        void passDataToHelloScreen(ByeToHelloState state);

        HelloToByeState getDataFromHelloScreen();
    }
}
