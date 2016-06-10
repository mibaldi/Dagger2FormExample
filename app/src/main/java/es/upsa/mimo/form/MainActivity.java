package es.upsa.mimo.form;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import es.upsa.mimo.form.app.FormApplication;

public class MainActivity extends AppCompatActivity implements FormView {

    @Inject
    protected FormPresenter mPresenter;

    private EditText nameEditView;
    private EditText surnamesEditView;
    private EditText addressEditView;

    private TextView ageCounterView;
    private Button ageDecrementButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((FormApplication)getApplication()).getInjector().inject(this);

        bindNameView();
        bindSurnameView();
        bindAddressView();
        bindAgeCounterView();
        bindSaveButton();

        mPresenter.onInitialize(this);
    }

    private void bindNameView() {
        View container = findViewById(R.id.name);
        TextView nameTitleView = (TextView) container.findViewById(R.id.nameField);
        nameTitleView.setText(R.string.name);

        nameEditView = (EditText) container.findViewById(R.id.editField);
        nameEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable name) {
                mPresenter.onChangeName(name.toString());
            }
        });
    }

    private void bindSurnameView() {
        View container = findViewById(R.id.surnames);
        TextView surnamesTitleView = (TextView) container.findViewById(R.id.nameField);
        surnamesTitleView.setText(R.string.surnames);

        surnamesEditView = (EditText) container.findViewById(R.id.editField);
        surnamesEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable surnames) {
                mPresenter.onChangeSurnames(surnames.toString());
            }
        });

    }

    private void bindAddressView() {
        View container = findViewById(R.id.address);
        TextView addressTitleView = (TextView) container.findViewById(R.id.nameField);
        addressTitleView.setText(R.string.address);

        addressEditView = (EditText) container.findViewById(R.id.editField);
        addressEditView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable address) {
                mPresenter.onChangeAddress(address.toString());
            }
        });
    }

    private void bindAgeCounterView() {
        View container = findViewById(R.id.age);
        TextView ageCounterTitleView = (TextView) container.findViewById(R.id.nameCounter);
        ageCounterTitleView.setText(R.string.age);

        ageCounterView = (TextView) container.findViewById(R.id.counter);

        container.findViewById(R.id.increment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onIncrementAge();
            }
        });

        ageDecrementButton = (Button) container.findViewById(R.id.decrement);
        ageDecrementButton.findViewById(R.id.decrement).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onDecrementAge();
            }
        });
    }

    private void bindSaveButton(){
        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onSave();
            }
        });
    }

    @Override
    public void disableDecrementAge() {
        ageDecrementButton.setEnabled(false);
    }

    @Override
    public void enableDecrementAge() {
        ageDecrementButton.setEnabled(true);
    }

    @Override
    public void showAge(String age) {
        ageCounterView.setText(age);
    }

    @Override
    public void showName(String name) {
        nameEditView.setText(name);
    }

    @Override
    public void showSurnames(String surnames) {
        surnamesEditView.setText(surnames);
    }

    @Override
    public void showAddress(String address) {
        addressEditView.setText(address);
    }
}
