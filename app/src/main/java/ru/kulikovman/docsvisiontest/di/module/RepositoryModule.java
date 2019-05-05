package ru.kulikovman.docsvisiontest.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.kulikovman.docsvisiontest.DataRepository;
import ru.kulikovman.docsvisiontest.api.DocvisionApi;

@Module(includes = NetworkModule.class)
public class RepositoryModule {

    @Singleton
    @Provides
    DataRepository provideDataRepository(DocvisionApi docvisionApi) {
        return new DataRepository(docvisionApi);
    }
}
