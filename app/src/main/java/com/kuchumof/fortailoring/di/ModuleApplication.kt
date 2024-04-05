package com.kuchumof.fortailoring.di

import android.content.Context
import com.kuchumof.fortailoring.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module // creation of hilt module
// components and scopes will be described later
@InstallIn(SingletonComponent::class)
object ModuleApplication { // kotlin object is needed

    // third party database
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getAppDatabase(context)
    }

}