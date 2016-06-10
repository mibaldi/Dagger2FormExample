package es.upsa.mimo.form;

/**
 * Created by sergiogarcia on 9/6/16.
 */
public interface FormView {
    void disableDecrementAge();

    void enableDecrementAge();

    void showAge(String age);

    void showName(String name);

    void showSurnames(String surnames);

    void showAddress(String address);

}
