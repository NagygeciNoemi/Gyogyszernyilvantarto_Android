package com.example.mhis.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mhis.databinding.FragmentLoginBinding;
import com.example.mhis.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment{

    private FragmentSettingsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingsViewModel loginViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*final TextView textView = binding.editTextTextUsername;
        loginViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

