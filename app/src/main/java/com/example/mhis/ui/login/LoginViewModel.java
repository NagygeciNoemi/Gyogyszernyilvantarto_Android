package com.example.mhis.ui.login;

import android.media.metrics.Event;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel
{

    private final MutableLiveData<String> mText;

    public LoginViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
            return mText;
        }
}