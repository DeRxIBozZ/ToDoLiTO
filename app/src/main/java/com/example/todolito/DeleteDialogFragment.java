package com.example.todolito;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class DeleteDialogFragment extends DialogFragment {

    private int position;
    private SelectedData mainactivity;

    @Override
    public Dialog onCreateDialog(Bundle savedInstance){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final DeleteDialogFragment ddf = this;
        builder.setMessage("ToDo löschen?")
                .setPositiveButton(R.string.loeschen, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mainactivity.onSelectedData(position);

                    }
                })
        .setNegativeButton(R.string.abbrechen, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

    return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {

        super.onAttach(activity);
        try{
            mainactivity = (SelectedData) activity;
        } catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    public void setPosition(int pos){
        this.position = pos;
    }
}
