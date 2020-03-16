package com.example.clean_code_helloworld_kilian.bye;

import java.lang.ref.WeakReference;

import androidx.fragment.app.FragmentActivity;

import com.example.clean_code_helloworld_kilian.R;
import com.example.clean_code_helloworld_kilian.app.AppMediator;

public class ByeScreen {

    public static void configure(ByeContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String message = context.get().getString(R.string.bye_message);

        AppMediator mediator = (AppMediator) context.get().getApplication();
        ByeState state = mediator.getByeState();

        ByeContract.Router router = new ByeRouter(mediator);
        ByeContract.Presenter presenter = new ByePresenter(state);
        ByeContract.Model model = new ByeModel(message);
        presenter.injectModel(model);
        presenter.injectRouter(router);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
