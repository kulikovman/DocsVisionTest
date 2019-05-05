package ru.kulikovman.docsvisiontest;

import android.app.Application;
import android.content.Context;

import ru.kulikovman.docsvisiontest.di.AppComponent;
import ru.kulikovman.docsvisiontest.di.DaggerAppComponent;
import ru.kulikovman.docsvisiontest.di.module.ContextModule;


public class App extends Application {

    private static App instance;

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        // Подключаем Dagger
        component = DaggerAppComponent.builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public static Context getContext() {
        return instance.getApplicationContext();
    }

    public static AppComponent getComponent() {
        return component;
    }
}
