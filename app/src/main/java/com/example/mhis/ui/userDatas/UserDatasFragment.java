package com.example.mhis.ui.userDatas;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.se.omapi.SEService;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mhis.Data;
import com.example.mhis.databinding.FragmentLoginBinding;
import com.example.mhis.databinding.FragmentUserdatasBinding;

import java.util.List;

public class UserDatasFragment extends Fragment
{

    private FragmentUserdatasBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        UserDatasViewModel userDatasViewModel = new ViewModelProvider(this).get(UserDatasViewModel.class);
        UserDatas userDatas = new UserDatas();
        RecyclerView recyclerView;



        binding = FragmentUserdatasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*final TextView textView = binding.textUserDatas;
        userDatasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

