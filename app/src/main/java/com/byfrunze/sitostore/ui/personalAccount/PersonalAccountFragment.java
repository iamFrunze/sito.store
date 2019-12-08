package com.byfrunze.sitostore.ui.personalAccount;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.byfrunze.sitostore.R;

public class PersonalAccountFragment extends Fragment {

    private PersonalAccountViewModel personalAccountViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        personalAccountViewModel = ViewModelProviders.of(this).get(PersonalAccountViewModel.class);
        View root = inflater.inflate(R.layout.fragment_personal_account, container, false);
        return root;

    }
}
