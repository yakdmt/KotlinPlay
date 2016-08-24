package xyz.yakdmt.kotlinplay.injection.modules

import android.app.Application
import android.content.Context
import android.location.LocationManager
import dagger.Module
import dagger.Provides
import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import xyz.yakdmt.kotlinplay.injection.ForApplication
import xyz.yakdmt.kotlinplay.model.Repository
import xyz.yakdmt.kotlinplay.network.NetworkService
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by yakdmt on 17/08/16.
 */
/**
 * A module for Android-specific dependencies which require a [android.content.Context] or [ ] to create.
 */
@Module
class AndroidModule(private val application: Application) {

    /**
     * Allow the application context to be injected but require that it be annotated with [ ][ForApplication] to explicitly differentiate it from an activity context.
     */
    @Provides
    @Singleton
    @ForApplication
    fun provideApplicationContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideLocationManager(): LocationManager {
        return application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    @Provides
    @Singleton
    fun provideRepository(): Repository {
        return Repository()
    }

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService {
        var retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.nytimes.com/svc/search/v2/")
                .build()
        return retrofit.create(NetworkService::class.java)
    }

    @Provides
    @Singleton
    @Named("something")
    fun provideSomething(): String {
        return "something"
    }

    @Provides
    @Singleton
    @Named("somethingElse")
    fun provideSomethingElse(): String {
        return "somethingElse"
    }

}
