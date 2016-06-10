package es.upsa.mimo.form.storage;

import android.content.SharedPreferences;
import javax.inject.Inject;
import es.upsa.mimo.form.model.Form;

/**
 * Created by sergiogarcia on 9/6/16.
 */
public class SharedPreferencesStorage implements Storage {

    private static final String KEY_NAME = "name";
    private static final String KEY_SURNAMES = "surnames";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_AGE = "age";

    private final SharedPreferences mSharedPreferences;

    /**
     * Request instance sharedPreferences to access their dependencies.
     * It is provided in the constructor
     * @param sharedPreferences
     */
    @Inject
    public SharedPreferencesStorage(SharedPreferences sharedPreferences) {
        this.mSharedPreferences = sharedPreferences;
    }

    @Override
    public Form load() {
        Form form = new Form();
        form.setName(mSharedPreferences.getString(KEY_NAME, ""));
        form.setSurnames(mSharedPreferences.getString(KEY_SURNAMES, ""));
        form.setAddress(mSharedPreferences.getString(KEY_ADDRESS, ""));
        form.setAge(mSharedPreferences.getInt(KEY_AGE, 0));
        return form;
    }

    @Override
    public void save(Form form) {
        mSharedPreferences.edit()
                .putString(KEY_NAME, form.getName())
                .putString(KEY_SURNAMES, form.getSurnames())
                .putString(KEY_ADDRESS, form.getAddress())
                .putInt(KEY_AGE, form.getAge())
                .apply();
    }
}
