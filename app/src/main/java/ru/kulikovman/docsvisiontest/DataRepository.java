package ru.kulikovman.docsvisiontest;

import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.kulikovman.docsvisiontest.api.DocvisionApi;
import ru.kulikovman.docsvisiontest.model.DatabaseInfo;
import ru.kulikovman.docsvisiontest.model.DatabasesRequest;
import ru.kulikovman.docsvisiontest.model.DatabasesResponse;
import ru.kulikovman.docsvisiontest.model.GetMessageRequestModel;
import ru.kulikovman.docsvisiontest.model.KnownMessageTypes;
import ru.kulikovman.docsvisiontest.model.SyncMessage;

public class DataRepository {

    private DocvisionApi api;
    public List<DatabaseInfo> databaseInfos;

    public DataRepository(DocvisionApi docvisionApi) {
        api = docvisionApi;
    }

    public List<DatabaseInfo> getListOfDatabases() {



        sendDatabasesRequest();


        return null;
    }







    private void sendDatabasesRequest() {
        DatabasesRequest request = new DatabasesRequest();
        final UUID requestId = UUID.randomUUID();

        SyncMessage message = new SyncMessage();
        message.setId(requestId);
        message.setRequestId(requestId);
        message.setMessageType(KnownMessageTypes.DATABASES_REQUEST);
        message.setMessage(new Gson().toJson(request));

        // Запрос на получение списка баз данных
        api.requestDatabases(message).enqueue(new Callback<SyncMessage>() {
            @Override
            public void onResponse(Call<SyncMessage> call, Response<SyncMessage> response) {
                getDatabasesAfterPause(requestId);
            }

            @Override
            public void onFailure(Call<SyncMessage> call, Throwable t) {
                Log.d("myLog", "Ошибка при requestDatabases / Throwable: " + t.getMessage());
            }
        });
    }

    private void getDatabasesAfterPause(final UUID requestId) {
        // Пауза перед получением данных (нужно для подготовки ответа сервером)
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getDatabases(requestId);
            }
        }, 500);
    }

    private void getDatabases(final UUID requestId) {
        GetMessageRequestModel messageRequestModel = new GetMessageRequestModel();
        messageRequestModel.setRequestId(requestId);

        // Получение списка баз данных
        api.getDatabases(messageRequestModel).enqueue(new Callback<List<SyncMessage>>() {
            @Override
            public void onResponse(Call<List<SyncMessage>> call, Response<List<SyncMessage>> response) {
                List<SyncMessage> messages = response.body();
                if (messages != null && messages.size() > 0) {
                    SyncMessage message = messages.get(0);
                    if (message.getMessageType().equals(KnownMessageTypes.DATABASES_RESPONSE)) {
                        DatabasesResponse databasesResponse = new Gson().fromJson(message.getMessage(), DatabasesResponse.class);
                        databaseInfos = databasesResponse.getDatabases();
                    } else {
                        Log.d("myLog", "Пришел неверный ответ");
                    }
                } else {
                    // Если список пустой, то получаем повторно
                    getDatabasesAfterPause(requestId);
                }
            }

            @Override
            public void onFailure(Call<List<SyncMessage>> call, Throwable t) {
                Log.d("myLog", "Ошибка при getDatabases / Throwable: " + t.getMessage());
            }
        });
    }





}
