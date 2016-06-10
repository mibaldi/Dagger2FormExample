package es.upsa.mimo.form.app;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dagger.Module;
import dagger.Provides;
import es.upsa.mimo.form.storage.SharedPreferencesStorage;
import es.upsa.mimo.form.storage.Storage;

/**
 * Created by sergiogarcia on 9/6/16.
 */
@Module
public class FormApplicationModule {

    private FormApplication mFormApplication;


    public FormApplicationModule(FormApplication formApplication) {
        this.mFormApplication = formApplication;
    }

    /**
     * Provide Storage to other classes for injection and use
     * @param sharedPreferencesStorage
     * @return
     */
    @Provides
    Storage provideStorage(SharedPreferencesStorage sharedPreferencesStorage){
        return sharedPreferencesStorage;
    }

    /**
     * Provide sharedPreferences to other classes for injection and use
     * @return
     */
    @Provides
    SharedPreferences provideSharedPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(mFormApplication);
    }

}
