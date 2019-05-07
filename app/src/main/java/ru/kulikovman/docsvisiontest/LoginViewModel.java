package ru.kulikovman.docsvisiontest;

import java.util.List;

import androidx.lifecycle.ViewModel;
import ru.kulikovman.docsvisiontest.model.DatabaseInfo;


public class LoginViewModel extends ViewModel {

    private DataRepository dataRepository;
    private List<DatabaseInfo> listOfDatabases;

    public LoginViewModel() {
        dataRepository = App.getComponent().getDataRepository();
    }

    public List<DatabaseInfo> getListOfDatabases() {
        if (listOfDatabases == null) {
            listOfDatabases = dataRepository.getListOfDatabases();
        }

        return listOfDatabases;
    }
}
