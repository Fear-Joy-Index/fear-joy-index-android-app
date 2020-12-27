package ru.nsu.fit.joyandfear.ui.settings;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.AlteredCharSequence;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.location.LocationServices;

import java.util.Locale;
import java.util.Objects;

import ru.nsu.fit.joyandfear.R;

import static android.content.Context.MODE_PRIVATE;

public class SettingsFragment extends Fragment {
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        loadLocal();
        //ActionBar actionBar = getActivity().getActionBar();
        //actionBar.setTitle(getResources().getString(R.string.bt_lang));

        Button changLang = v.findViewById(R.id.button_lang);
        changLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLanguageDialog();
            }
        });

        return v;
    }

    private void showChangeLanguageDialog(){
        final String[] listItems = {"English", "Русский"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        mBuilder.setTitle("Choose Language:");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0){
                    setLocale("en");
                    requireActivity().recreate();
                }
                else if (i == 1){
                    setLocale("ru");
                    requireActivity().recreate();
                }

                dialogInterface.dismiss();
            }
        });

        AlertDialog mDiolog = mBuilder.create();
        mDiolog.show();
    }

    private void setLocale(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(config, requireActivity().getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = requireActivity().getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    public void loadLocal(){
        SharedPreferences prefs = requireActivity().getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String lang = prefs.getString("My_Lang", "");
        setLocale(lang);
    }
}
