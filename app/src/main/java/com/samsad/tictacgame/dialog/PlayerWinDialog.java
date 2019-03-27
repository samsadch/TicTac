package com.samsad.tictacgame.dialog;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.samsad.tictacgame.MainActivity;
import com.samsad.tictacgame.R;


public class PlayerWinDialog extends DialogFragment {

    public  static PlayerWinDialog frag;

    public static PlayerWinDialog newInstance(String  message) {
        if(frag==null) {
            frag = new PlayerWinDialog();
        }
        Bundle args = new Bundle();
        args.putString("MESSAGE",message);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String mesage = null;
        try{
            mesage = savedInstanceState.getString("MESSAGE");
        }catch (Exception e){
            e.printStackTrace();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.alert_plyer_wins, null);

        // Set transparent background and no title
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }

        TextView trackBtn = view.findViewById(R.id.trackBtn);
        TextView messageTxv = view.findViewById(R.id.messageTxv);

        messageTxv.setText(mesage);

        builder.setView(view);
        trackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        return builder.create();
    }

}