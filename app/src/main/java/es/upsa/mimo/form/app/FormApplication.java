package es.upsa.mimo.form.app;

import android.app.Application;

/**
 * Created by sergiogarcia on 9/6/16.
 * Injector is created and initialized
 */
public class FormApplication extends Application {

    private FormApplicationComponent mFormApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mFormApplicationComponent = DaggerFormApplicationComponent.builder()
                .formApplicationModule(new FormApplicationModule(this))
                .build();
    }

    public FormApplicationComponent getInjector() {
        return mFormApplicationComponent;
    }
}
