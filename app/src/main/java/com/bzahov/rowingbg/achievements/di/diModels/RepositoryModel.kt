package com.bzahov.rowingbg.achievements.di.diModels

import com.bzahov.rowingbg.achievements.data.repositories.UserAuthRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val repositoryModule = Kodein.Module("repository") {
    bind/*<UserAuthRepository>*/() from singleton { UserAuthRepository(instance(),instance(),instance()) }
}