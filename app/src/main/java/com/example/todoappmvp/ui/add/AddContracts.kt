package com.example.todoappmvp.ui.add

import com.example.todoappmvp.data.model.NoteEntity

interface AddContracts {
    interface View {
        fun close()
        fun loadNote(noteEntity: NoteEntity)
    }

    interface Presenter {
        fun saveNote(noteEntity: NoteEntity)
        fun getNote(id: Int)
        fun updateNote(noteEntity: NoteEntity)
    }
}