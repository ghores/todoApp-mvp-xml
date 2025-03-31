package com.example.todoappmvp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoappmvp.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao
}