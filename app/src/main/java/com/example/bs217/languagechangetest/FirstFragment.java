package com.example.bs217.languagechangetest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstFragment extends Fragment {

    Button changeLanguageButton, goToSecondButton, goToThirdButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(getString(R.string.first_fragment));

        changeLanguageButton = getView().findViewById(R.id.languageButton);
        goToSecondButton = getView().findViewById(R.id.secondFragmentButton);
        goToThirdButton = getView().findViewById(R.id.thirdFragmentButton);

        changeLanguageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).changeLanguage();
            }
        });

        goToSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.container, new SecondFragment()).addToBackStack(null).commit();
            }
        });

        goToThirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.container, new ThirdFragment()).addToBackStack(null).commit();
            }
        });

    }
}
