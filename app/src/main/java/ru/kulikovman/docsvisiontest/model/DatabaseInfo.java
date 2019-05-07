package ru.kulikovman.docsvisiontest.model;

import java.util.UUID;

public class DatabaseInfo {

    private UUID DatabaseId;
    private String DisplayName;
    private boolean IsDefault;

    public UUID getDatabaseId() {
        return DatabaseId;
    }

    public void setDatabaseId(UUID databaseId) {
        DatabaseId = databaseId;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public boolean isDefault() {
        return IsDefault;
    }

    public void setDefault(boolean aDefault) {
        IsDefault = aDefault;
    }
}
