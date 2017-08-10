package com.thethtun.beta.yawthamamew.fragments;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.thethtun.beta.yawthamamew.R;
import com.thethtun.beta.yawthamamew.UnitConverterTextWatcher;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LengthAreaWeightVolumeFragment extends Fragment {

    private static final String TAG = LengthAreaWeightVolumeFragment.class.getSimpleName();


    @BindView(R.id.row1_unit_text)
    TextView row1_unit_text;

    @BindView(R.id.row2_unit_text)
    TextView row2_unit_text;

    @BindView(R.id.row1_unit_editText)
    EditText row1_unit_editText;

    @BindView(R.id.row2_unit_editText)
    EditText row2_unit_editText;

    private View rootView;
    private String userInput;

    public LengthAreaWeightVolumeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_length_area_weight_volume, container, false);
        ButterKnife.bind(this, rootView);
        row1_unit_text.setText(R.string.feet_abbrv);
        focusChangedListener(row1_unit_editText);
        row2_unit_text.setText(R.string.yard_abbrv);
        focusChangedListener(row2_unit_editText);
//        editTextChangedListener(row2_unit_editText);
        return rootView;
    }

    public void focusChangedListener(final EditText editText){
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
//                    Toast.makeText(getContext(), "Focus On", Toast.LENGTH_SHORT).show();
                    addEditTextChangedListener(editText);
//                    InputDialogBoxFragment dialogBoxFragment = new InputDialogBoxFragment();
//                    dialogBoxFragment.show(getChildFragmentManager(), "Just a string");
                    summonInputDialogBox(editText);

                }else{
                    Toast.makeText(getContext(), "Focus Off", Toast.LENGTH_SHORT).show();
                    removeEditTextChangedListener(editText);
                }
            }
        });
    }

    public void addEditTextChangedListener(final EditText editText){
        editText.addTextChangedListener(new UnitConverterTextWatcher(editText, rootView));
    }

    public void removeEditTextChangedListener(final EditText editText){
        editText.removeTextChangedListener(new UnitConverterTextWatcher(editText, rootView));
    }

    private void summonInputDialogBox(final EditText editTextRow){

//        final EditText editText = new EditText(getContext());
//        editText.setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL);
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
//        builder1.setMessage("Enter your damn shit");
//        builder1.setView(editText);
        builder1.setView(R.layout.fragment_input_dialog_box);
        final View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_input_dialog_box,null);
        builder1.setCancelable(true);



        builder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Dialog f = (Dialog) dialog;
                EditText editText = (EditText) f.findViewById(R.id.userInput);
                if(editText.getText()!=null){
                    userInput = editText.getText().toString();
                    Log.d("userInput", String.valueOf(userInput));
                    editTextRow.setText(userInput);
                }else{
                    userInput = "0";
                }
            }
        });

        builder1.setNegativeButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }

}
