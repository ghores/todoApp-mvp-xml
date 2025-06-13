package com.example.todoappmvp.utils.di

import android.content.Context
import androidx.room.Room
import com.example.todoappmvp.data.database.NoteDatabase
import com.example.todoappmvp.data.model.NoteEntity
import com.example.todoappmvp.utils.NOTE_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, NoteDatabase::class.java, NOTE_DATABASE_NAME
    ).allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(db: NoteDatabase) = db.noteDao

    @Provides
    @Singleton
    fun provideEntity() = NoteEntity()
}