package ru.kulikovman.docsvisiontest.model;

import java.util.List;
import java.util.UUID;

public class GetMessageRequestModel {

    private List<UUID> ReceivedMessageIds;
    private UUID RequestId;
    private SessionToken SessionToken;

    public List<UUID> getReceivedMessageIds() {
        return ReceivedMessageIds;
    }

    public void setReceivedMessageIds(List<UUID> receivedMessageIds) {
        ReceivedMessageIds = receivedMessageIds;
    }

    public UUID getRequestId() {
        return RequestId;
    }

    public void setRequestId(UUID requestId) {
        RequestId = requestId;
    }

    public ru.kulikovman.docsvisiontest.model.SessionToken getSessionToken() {
        return SessionToken;
    }

    public void setSessionToken(ru.kulikovman.docsvisiontest.model.SessionToken sessionToken) {
        SessionToken = sessionToken;
    }
}
