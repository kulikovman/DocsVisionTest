package ru.kulikovman.docsvisiontest.di;

import dagger.Module;
import dagger.Provides;
import ru.kulikovman.docsvisiontest.DataRepository;

@Module
public class DataRepositoryModule {

    @Provides
    DataRepository provideDataRepository() {
        return new DataRepository();
    }
}
