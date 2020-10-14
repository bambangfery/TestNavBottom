package com.test.alodoktertes.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.test.alodoktertes.MainActivity;
import com.test.alodoktertes.R;
import com.test.alodoktertes.utils.PrefManager;


public class LogoutDialog extends DialogFragment {

    private static PrefManager pref ;
    private Button yesBtn, noBtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_logout, container, false);

        yesBtn = (Button) view.findViewById(R.id.yesBtn);
        noBtn  = (Button) view.findViewById(R.id.noBtn);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pref = new PrefManager(getContext());
                pref.setClearPrefrencessLogout();
                Intent i = new Intent(getContext(), MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                getDialog().dismiss();
            }
        });

        return view;
    }

}
