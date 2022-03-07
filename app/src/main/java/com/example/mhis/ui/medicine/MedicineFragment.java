package com.example.mhis.ui.medicine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mhis.databinding.FragmentMedicineBinding;

public class MedicineFragment extends Fragment{

    private FragmentMedicineBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MedicineViewModel medicineViewModel =
                new ViewModelProvider(this).get(MedicineViewModel.class);

        binding = FragmentMedicineBinding.inflate(inflater, container, false);
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

