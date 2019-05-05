package ru.kulikovman.docsvisiontest.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.kulikovman.docsvisiontest.model.GetMessageRequestModel;
import ru.kulikovman.docsvisiontest.model.SyncMessage;

public interface DocvisionApi {

    @POST("Api/SyncMessage/PostMessage")
    Call<SyncMessage> requestDatabaseList(@Body SyncMessage syncMessage);

    @POST("Api/SyncMessage/GetMessages/")
    Call<List<SyncMessage>> getDatabaseList(@Body GetMessageRequestModel getMessageRequestModel);
}
