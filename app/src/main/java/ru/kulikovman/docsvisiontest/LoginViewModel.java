package ru.kulikovman.docsvisiontest;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import ru.kulikovman.docsvisiontest.model.DatabaseInfo;


public class LoginViewModel extends ViewModel {

    private DataRepository dataRepository;
    private LiveData<List<DatabaseInfo>> listOfDatabases;

    public LoginViewModel() {
        dataRepository = App.getComponent().getDataRepository();
        listOfDatabases = dataRepository.getListOfDatabases();
    }

    public LiveData<List<DatabaseInfo>> getListOfDatabases() {
        return listOfDatabases;
    }
}
