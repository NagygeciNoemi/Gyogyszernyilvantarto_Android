package com.example.mhis.ui.doctors;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mhis.DoctorActivity;
import com.example.mhis.R;
import com.example.mhis.databinding.FragmentDoctorsBinding;

public class DoctorFragment extends Fragment{

    private FragmentDoctorsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Intent intent = new Intent(getActivity(), DoctorActivity.class);
        startActivity(intent);

        DoctorViewModel doctorViewModel =
                new ViewModelProvider(this).get(DoctorViewModel.class);

        View root = inflater.inflate(R.layout.fragment_doctors, container, false);
        @SuppressLint("ResourceType") ListView listView = (ListView) root.findViewById(R.layout.fragment_doctors);
        /*final TextView textView = binding.editTextTextUsername;
        loginViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/


        return listView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

