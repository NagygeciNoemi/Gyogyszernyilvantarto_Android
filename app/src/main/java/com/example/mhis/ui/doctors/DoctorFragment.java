package com.example.mhis.ui.doctors;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mhis.databinding.FragmentDoctorsBinding;
import com.example.mhis.databinding.FragmentLoginBinding;

public class DoctorFragment extends Fragment{

    private FragmentDoctorsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DoctorViewModel loginViewModel =
                new ViewModelProvider(this).get(DoctorViewModel.class);

        binding = FragmentDoctorsBinding.inflate(inflater, container, false);
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

