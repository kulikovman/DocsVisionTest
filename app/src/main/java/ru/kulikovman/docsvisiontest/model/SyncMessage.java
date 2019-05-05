package ru.kulikovman.docsvisiontest.model;

import java.util.UUID;

public class SyncMessage {

    private UUID id;
    private String message;
    private String messageType;
    private UUID requestId;
    private SessionToken sessionToken;
    private long settingsHash;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    public long getSettingsHash() {
        return settingsHash;
    }

    public void setSettingsHash(long settingsHash) {
        this.settingsHash = settingsHash;
    }
}
