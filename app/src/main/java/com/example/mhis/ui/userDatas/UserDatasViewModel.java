package com.example.mhis.ui.userDatas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserDatasViewModel extends ViewModel
{

    private final MutableLiveData<String> mText;

    public UserDatasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is user datas fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}