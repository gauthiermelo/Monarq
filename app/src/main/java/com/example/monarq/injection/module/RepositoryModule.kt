package com.example.monarq.injection.module
import com.example.monarq.network.Repository

import dagger.Module
import dagger.Provides
import dagger.Reusable


/**
 * Module which provides all required dependencies about network
 */
@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object RepositoryModule {

    /**
     * Provides the Repository implementation.
     * @return the Repository implementation.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRepository(): Repository {
        return Repository()
    }


}