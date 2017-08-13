package com.thethtun.beta.yawthamamew;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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

    @BindView(R.id.row3_unit_editText)
    EditText row3_unit_editText;

    @BindView(R.id.row4_unit_editText)
    EditText row4_unit_editText;

    @BindView(R.id.row5_unit_editText)
    EditText row5_unit_editText;

    @BindView(R.id.row6_unit_editText)
    EditText row6_unit_editText;

    @BindView(R.id.row7_unit_editText)
    EditText row7_unit_editText;

    @BindView(R.id.row8_unit_editText)
    EditText row8_unit_editText;

    @BindView(R.id.row9_unit_editText)
    EditText row9_unit_editText;

    @BindView(R.id.row10_unit_editText)
    EditText row10_unit_editText;

    @BindView(R.id.row11_unit_editText)
    EditText row11_unit_editText;

    @BindView(R.id.row12_unit_editText)
    EditText row12_unit_editText;

    @BindView(R.id.row13_unit_editText)
    EditText row13_unit_editText;

    @BindView(R.id.row14_unit_editText)
    EditText row14_unit_editText;

    @BindView(R.id.row15_unit_editText)
    EditText row15_unit_editText;

    @BindView(R.id.row16_unit_editText)
    EditText row16_unit_editText;

    @BindView(R.id.row17_unit_editText)
    EditText row17_unit_editText;

    @BindView(R.id.row18_unit_editText)
    EditText row18_unit_editText;

    @BindView(R.id.row19_unit_editText)
    EditText row19_unit_editText;

    @BindView(R.id.row20_unit_editText)
    EditText row20_unit_editText;

    private EditText editText;
    private TextView textView;
    private Context context;
    private Resources resources;
    private double baseValue;

    public UnitConverterTextWatcher(EditText editText, View rootView, TextView textView, Context context) {
        this.editText = editText;
        this.textView = textView;
        this.context = context;
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
        if(editText.getText().toString().equals("")){
            //Do Nothing for now

        }else{
            Log.d("Check this out --> ", editText.getText().toString());
            double input = Double.parseDouble(editText.getText().toString());
            if(context!=null){
                resources = context.getResources();
            }

            if(textView.getText().equals(resources.getString(R.string.micrometer))){
                //No Need To Do Anything
                baseValue = input;
            }

            if(textView.getText().equals(resources.getString(R.string.millimeter))){
                baseValue = fromMilliMeterToMicroMeter(input);
            }


            //Calculation and display
            if(!row1_unit_editText.getText().toString().equals(String.valueOf(getMicroMeter(baseValue)))){
                row1_unit_editText.setText(String.valueOf(getMicroMeter(baseValue)));
            }
            if(!row2_unit_editText.getText().toString().equals(String.valueOf(getMilliMeter(baseValue)))){
                row2_unit_editText.setText(String.valueOf(getMilliMeter(baseValue)));
            }
        }
    }

    public double getMicroMeter(double input){
        return input;
    }

    public double getMilliMeter(double input){
        return getMicroMeter(input) / 1000;
    }

    public double fromMilliMeterToMicroMeter(double input){
        return input * 1000;
    }

    public double fromCentiMeterToMilliMeter(double input){
        return input * 1000;
    }
}

