package com.bzahov.rowingbg.achievements.di.diModels

import com.bzahov.rowingbg.achievements.di.bindViewModel
import com.bzahov.rowingbg.achievements.ui.activities.auth.AuthViewModelFactory
import com.bzahov.rowingbg.achievements.ui.activities.main.MainActivityViewModelFactory
import com.bzahov.rowingbg.achievements.ui.fragments.home.HomeViewModel
import com.bzahov.rowingbg.achievements.ui.fragments.profile.ProfileViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val viewModelModule = Kodein.Module("viewModel") {
//    bindViewModel<MainActivityViewModel>() to provider {
//        MainActivityViewModel(
//            instance()
//        )
//    }
    bind() from provider { MainActivityViewModelFactory(instance()) }
    bind() from provider { ProfileViewModel(instance()) }
    bind() from provider { AuthViewModelFactory(instance()) }

//        bind() from provider { HomeViewModelFactory() }
//        bind() from provider { MyArtItemsViewModelFactory(instance) }
//        bind() from provider { PortfolioViewModelFactory(instance) }
    bindViewModel<HomeViewModel>() with provider {
        HomeViewModel(
//            instance()
        )
    }
    bindViewModel<ProfileViewModel>() with provider {
        ProfileViewModel(
            instance()
        )
    }
//    bindViewModel<AuthViewModel>() with provider {
//        AuthViewModel(
//            instance()
//        )
//    }

}