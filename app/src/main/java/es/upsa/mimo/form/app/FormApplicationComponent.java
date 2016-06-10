package es.upsa.mimo.form.app;

import dagger.Component;
import es.upsa.mimo.form.MainActivity;

/**
 * Created by sergiogarcia on 9/6/16.
 * Modules that make up the component : FruitsApplicationModule
 */
@Component(modules = {FormApplicationModule.class})
public interface FormApplicationComponent {

    /**
     * Dependency injection on MainActivity class
     * @param mainActivity
     */
    void inject(MainActivity mainActivity);
}
