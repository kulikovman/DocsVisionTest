package ru.kulikovman.docsvisiontest.di;

import javax.inject.Singleton;

import dagger.Component;
import ru.kulikovman.docsvisiontest.DataRepository;
import ru.kulikovman.docsvisiontest.di.module.ContextModule;
import ru.kulikovman.docsvisiontest.di.module.NetworkModule;
import ru.kulikovman.docsvisiontest.di.module.RepositoryModule;

@Singleton
@Component(modules = {RepositoryModule.class, NetworkModule.class, ContextModule.class})
public interface AppComponent {
    DataRepository getDataRepository();
}
