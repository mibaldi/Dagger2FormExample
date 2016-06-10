package es.upsa.mimo.form.storage;

import es.upsa.mimo.form.model.Form;

/**
 * Created by sergiogarcia on 9/6/16.
 */
public interface Storage {

    Form load();

    void save(Form form);
}
