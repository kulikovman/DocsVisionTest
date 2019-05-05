package ru.kulikovman.docsvisiontest;

import android.util.Log;

import androidx.lifecycle.ViewModel;


public class LoginViewModel extends ViewModel {

    private DataRepository dataRepository;

    public LoginViewModel() {
        dataRepository = App.getComponent().getDataRepository();
    }

    public void getListOfDatabases() {
        if (dataRepository != null) {
            Log.d("myLog", "dataRepository != null");
            dataRepository.getListOfDatabases();
        } else {
            Log.d("myLog", "dataRepository == null");
        }
    }
}
