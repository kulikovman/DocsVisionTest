package ru.kulikovman.docsvisiontest;

import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.kulikovman.docsvisiontest.api.DocvisionApi;
import ru.kulikovman.docsvisiontest.model.DatabasesRequest;
import ru.kulikovman.docsvisiontest.model.GetMessageRequestModel;
import ru.kulikovman.docsvisiontest.model.KnownMessageTypes;
import ru.kulikovman.docsvisiontest.model.SyncMessage;

public class DataRepository {

    private DocvisionApi api;
    private List<SyncMessage> messages;

    public DataRepository(DocvisionApi docvisionApi) {
        api = docvisionApi;
    }

    public void getListOfDatabases() {

        DatabasesRequest request = new DatabasesRequest();
        final UUID requestId = UUID.randomUUID();

        SyncMessage message = new SyncMessage();
        message.setRequestId(requestId);
        message.setMessageType(KnownMessageTypes.DATABASES_REQUEST);

        Gson gson = new Gson();
        message.setMessage(gson.toJson(request));

        Log.d("myLog", "Запрашиваем список баз даных");
        api.requestDatabaseList(message).enqueue(new Callback<SyncMessage>() {
            @Override
            public void onResponse(Call<SyncMessage> call, Response<SyncMessage> response) {
                Log.d("myLog", "Запрос на получение базы данных успешно прошел");
            }

            @Override
            public void onFailure(Call<SyncMessage> call, Throwable t) {
                Log.d("myLog", "Ошибка при отправке запроса на получение базы данных!");
            }
        });

        runAfterOneSecond(requestId);

    }

    private void runAfterOneSecond(final UUID requestId) {
        Log.d("myLog", "Ждем 3 секунды");
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getDatabaseList(requestId);
            }
        }, 3000);
    }

    private void getDatabaseList(final UUID requestId) {
        GetMessageRequestModel messageRequestModel = new GetMessageRequestModel();
        messageRequestModel.setRequestId(requestId);

        messages = new ArrayList<>();

        Log.d("myLog", "Получаем список баз даных");
        api.getDatabaseList(messageRequestModel).enqueue(new Callback<List<SyncMessage>>() {
            @Override
            public void onResponse(Call<List<SyncMessage>> call, Response<List<SyncMessage>> response) {
                Log.d("myLog", "Ошибка при получении списка баз данных");
                messages = response.body();

                if (messages != null) {
                    Log.d("myLog", "Количество записей в ответе: " + messages.size());

                    // Дальше разбираем то, что получили...


                } else {
                    Log.d("myLog", "Список messages пустой!");
                    //runAfterOneSecond(requestId);
                }
            }

            @Override
            public void onFailure(Call<List<SyncMessage>> call, Throwable t) {
                Log.d("myLog", "Ошибка при получении списка баз данных!");
            }
        });
    }


}
