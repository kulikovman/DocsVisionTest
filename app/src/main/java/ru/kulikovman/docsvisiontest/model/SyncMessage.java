package ru.kulikovman.docsvisiontest.model;

import java.util.UUID;

public class SyncMessage {

    private UUID Id;
    private UUID RequestId;
    private String MessageType;
    private String Message;
    private long SettingsHash;
    private SessionToken SessionToken;

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public UUID getRequestId() {
        return RequestId;
    }

    public void setRequestId(UUID requestId) {
        RequestId = requestId;
    }

    public String getMessageType() {
        return MessageType;
    }

    public void setMessageType(String messageType) {
        MessageType = messageType;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public long getSettingsHash() {
        return SettingsHash;
    }

    public void setSettingsHash(long settingsHash) {
        SettingsHash = settingsHash;
    }

    public ru.kulikovman.docsvisiontest.model.SessionToken getSessionToken() {
        return SessionToken;
    }

    public void setSessionToken(ru.kulikovman.docsvisiontest.model.SessionToken sessionToken) {
        SessionToken = sessionToken;
    }
}
