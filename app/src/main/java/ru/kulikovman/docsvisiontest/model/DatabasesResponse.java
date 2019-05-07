package ru.kulikovman.docsvisiontest.model;

import java.util.List;

public class DatabasesResponse {

    public List<DatabaseInfo> Databases;

    public List<DatabaseInfo> getDatabases() {
        return Databases;
    }

    public void setDatabases(List<DatabaseInfo> databases) {
        Databases = databases;
    }
}
