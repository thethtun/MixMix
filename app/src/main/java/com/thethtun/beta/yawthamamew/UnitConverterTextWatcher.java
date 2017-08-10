package com.thethtun.beta.yawthamamew;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by beta on 8/10/17.
 */

public class UnitConverterTextWatcher implements TextWatcher {

    @BindView(R.id.row1_unit_editText)
    EditText row1_unit_editText;

    @BindView(R.id.row2_unit_editText)
    EditText row2_unit_editText;

    private EditText editText;

    public UnitConverterTextWatcher(EditText editText, View rootView) {
        this.editText = editText;
        ButterKnife.bind(this, rootView);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(editText.getText().toString().equals("") || editText.getText().toString().equals("0")){
                    //Do Nothing for now

                }else{
                    Log.d("Check this out --> ", editText.getText().toString());
                    double input = Double.parseDouble(editText.getText().toString());
                    if(editText.equals(row1_unit_editText)){
                        Log.d("EditTextListener","ListeningOnEditTextOne");
//                        row1_unit_editText.setText(String.valueOf(input));
                        if(!row2_unit_editText.getText().toString().equals(String.valueOf(input)) ){
                            row2_unit_editText.setText(String.valueOf(input / 3));
                        }
                    }

                    if(editText.equals(row2_unit_editText)){
                        Log.d("EditTextListener","ListeningOnEditTextTwo");
                        if(!row1_unit_editText.getText().toString().equals(String.valueOf(input)) ){
                            row1_unit_editText.setText(String.valueOf(input * 3));
                        }
//                        row2_unit_editText.setText(String.valueOf(input));
                    }

                }
            }
        }, 700);

    }
}

