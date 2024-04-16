package com.kuchumof.fortailoring.di

import android.content.Context
import androidx.room.Room
import com.kuchumof.fortailoring.ForTailoringApplication
import com.kuchumof.fortailoring.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module // creation of hilt module
// components and scopes will be described later
@InstallIn(SingletonComponent::class)
object ModuleApplication { // kotlin object is needed

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): ForTailoringApplication {
        return app as ForTailoringApplication
    }

    @Singleton // Tell Dagger-Hilt to create a singleton accessible everywhere in ApplicationComponent (i.e. everywhere in the application)
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        "forTailoring.db"
    ).build() // The reason we can construct a database for the repo

    @Singleton
    @Provides
    fun provideFolderDao(db: AppDatabase) =
        db.folderDao() // The reason we can implement a Dao for the database

    @Singleton
    @Provides
    fun provideOrderDao(db: AppDatabase) =
        db.orderItemDao() // The reason we can implement a Dao for the database

}