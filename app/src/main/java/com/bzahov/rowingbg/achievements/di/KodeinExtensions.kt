package com.bzahov.rowingbg.achievements.di

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.direct
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.on

inline fun <reified VM : ViewModel, T> T.activityViewModel(): Lazy<VM> where T : KodeinAware, T : AppCompatActivity {
    return viewModels(factoryProducer = { direct.instance() })
}

inline fun <reified VM : ViewModel, T> T.activityViewModel(): Lazy<VM> where T : KodeinAware, T : FragmentActivity {
    return viewModels(factoryProducer = { direct.instance() })
}

inline fun <reified VM : ViewModel, T> T.activityScopedFragmentViewModel(): Lazy<VM> where T : KodeinAware, T : Fragment {
    return viewModels(ownerProducer = { requireParentFragment() },
        factoryProducer = { getFactoryInstance() })
}

inline fun <reified VM : ViewModel, T> T.fragmentViewModel(): Lazy<VM> where T : KodeinAware, T : Fragment {
    return viewModels(factoryProducer = { getFactoryInstance() })
}

inline fun <reified VM : ViewModel> Kodein.Builder.bindViewModel(overrides: Boolean? = null): Kodein.Builder.TypeBinder<VM> {
    return bind<VM>(VM::class.java.simpleName, overrides)
}

fun <T> T.getFactoryInstance(
): ViewModelProvider.Factory where T : KodeinAware, T : Fragment {
    val viewModeFactory: ViewModelProvider.Factory by kodein.on(activity).instance()
    return viewModeFactory
}