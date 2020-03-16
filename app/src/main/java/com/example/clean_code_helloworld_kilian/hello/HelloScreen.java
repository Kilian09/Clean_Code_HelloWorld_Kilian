package com.example.clean_code_helloworld_kilian.hello;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.clean_code_helloworld_kilian.app.AppMediator;
import com.example.clean_code_helloworld_kilian.R;

public class HelloScreen {

    public static void configure(HelloContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String message = context.get().getString(R.string.hello_message);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        HelloState state = mediator.getHelloState();

        HelloContract.Router router = new HelloRouter(mediator);
        HelloContract.Presenter presenter = new HelloPresenter(state);
        HelloContract.Model model = new HelloModel(message);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
