package ru.kulikovman.docsvisiontest.model;

import java.util.List;
import java.util.UUID;

public class GetMessageRequestModel {

    private List<UUID> receivedMessageIds;
    private UUID requestId;
    private SessionToken sessionToken;

    public List<UUID> getReceivedMessageIds() {
        return receivedMessageIds;
    }

    public void setReceivedMessageIds(List<UUID> receivedMessageIds) {
        this.receivedMessageIds = receivedMessageIds;
    }

    public UUID getRequestId() {
        return requestId;
    }

    public void setRequestId(UUID requestId) {
        this.requestId = requestId;
    }

    public SessionToken getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(SessionToken sessionToken) {
        this.sessionToken = sessionToken;
    }
}
