package xyz.yakdmt.kotlinplay

import android.app.Application
import android.location.LocationManager
import xyz.yakdmt.kotlinplay.injection.component.ApplicationComponent
import xyz.yakdmt.kotlinplay.injection.component.DaggerApplicationComponent
import xyz.yakdmt.kotlinplay.injection.modules.AndroidModule
import javax.inject.Inject

/**
 * Created by yakdmt on 17/08/16.
 */
class MyApplication : Application() {

    companion object {
        //platformStatic allow access it from java code
        @JvmStatic lateinit var graph: ApplicationComponent
    }

    @Inject
    lateinit var locationManager: LocationManager

    override fun onCreate() {
        super.onCreate()
        graph = DaggerApplicationComponent.builder().androidModule(AndroidModule(this)).build()
        graph.inject(this)

        println("App: $locationManager")
        //TODO do some other cool stuff here
    }
}