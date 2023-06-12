package com.bzahov.rowingbg.achievements

import android.app.Application
import android.content.res.Resources
import com.bzahov.rowingbg.achievements.data.firebase.FirebaseAuthDataSource
import com.bzahov.rowingbg.achievements.data.firebase.FirebaseCloudDataSource
import com.bzahov.rowingbg.achievements.data.firebase.FirebaseDatabaseDataSource
import com.bzahov.rowingbg.achievements.di.diModels.repositoryModule
import com.bzahov.rowingbg.achievements.di.diModels.viewModelModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

//@HiltAndroidApp
class RowingBGApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@RowingBGApplication))
//        bind() from provider { MainActivityViewModelFactory(instance()) }

        import(repositoryModule)
        import(viewModelModule)

        //Firebase Data sources
        bind() from singleton { FirebaseAuthDataSource() }
        bind() from singleton { FirebaseDatabaseDataSource() }
        bind() from singleton { FirebaseCloudDataSource() }
        // Repositories
//        bind() from singleton { UserAuthRepository(instance(), instance(), instance()) }
//        bind() from singleton { ItemsRepository(instance(), instance(), instance()) }

        // ViewModels Factories
//        bind() from provider { AuthViewModelFactory(instance()) }
//        bind() from provider { ProfileViewModel(instance()) }
//        bind() from provider { HomeViewModelFactory() }
//        bind() from provider { MyArtItemsViewModelFactory(instance) }
//        bind() from provider { PortfolioViewModelFactory(instance) }
    }

    override fun onCreate() {
        super.onCreate()
        // PreferenceManager.setDefaultValues(this,R.xml.preferences,false)
        resourcesNew = resources

    }

    companion object {
        var resourcesNew: Resources? = null

        fun getAppResources(): Resources? {
            return resourcesNew
        }

        fun getAppString(id: Int): String {
            return resourcesNew?.getString(id) ?: ""
        }
    }
}