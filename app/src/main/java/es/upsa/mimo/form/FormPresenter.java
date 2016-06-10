package es.upsa.mimo.form;

import javax.inject.Inject;

import es.upsa.mimo.form.model.Form;
import es.upsa.mimo.form.storage.Storage;

/**
 * Created by sergiogarcia on 9/6/16.
 */
public class FormPresenter {

    private Storage mStorage;
    private Form mForm;
    private FormView mView;

    /**
     * Request instance storage to access their dependencies. It is provided in the constructor
     * @param storage
     */
    @Inject
    public FormPresenter(Storage storage) {
        this.mStorage = storage;
    }

    public void onInitialize(FormView view){
        mView = view;
        load();
        showCurrentAge();
        showCurrentName();
        showCurrentSurnames();
        showCurrentAddress();
    }

    private void load() {
        mForm = mStorage.load();
    }

    public void onDecrementAge() {
        mForm.decrementAge();
        showCurrentAge();
    }

    public void onIncrementAge() {
        mForm.incrementAge();
        showCurrentAge();
    }

    private void showCurrentAge() {
        mView.showAge(String.valueOf(mForm.getAge()));
        if(mForm.getAge() > 0 ){
            mView.enableDecrementAge();
        } else{
            mView.disableDecrementAge();
        }
    }

    public void onSave() {
        mStorage.save(mForm);
    }

    public void onChangeName(String name) {
        mForm.setName(name);
    }

    public void onChangeSurnames(String surnames) {
        mForm.setSurnames(surnames);
    }

    public void onChangeAddress(String address) {
        mForm.setAddress(address);
    }

    public void showCurrentName(){
        mView.showName(mForm.getName());
    }

    public void showCurrentSurnames(){
        mView.showSurnames(mForm.getSurnames());
    }

    public void showCurrentAddress(){
        mView.showAddress(mForm.getAddress());
    }
}
