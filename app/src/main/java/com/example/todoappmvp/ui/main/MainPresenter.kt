package com.example.todoappmvp.ui.main

import com.example.todoappmvp.base.BasePresenterImpl
import com.example.todoappmvp.data.model.NoteEntity
import com.example.todoappmvp.data.repository.main.MainRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val repository: MainRepository,
    private val view: MainContracts.View
) : MainContracts.Presenter, BasePresenterImpl() {
    override fun getAllNotes() {
        disposable = repository.getAllNotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                if (it.isNotEmpty()) {
                    view.showAllNotes(it)
                } else {
                    view.showEmpty()
                }
            }
    }

    override fun deleteNote(noteEntity: NoteEntity) {
        disposable = repository.deleteNote(noteEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view.deleteMessage()
            }
    }

    override fun filterNote(priority: String) {
        disposable = repository.filterNote(priority)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                if (it.isNotEmpty()) {
                    view.showAllNotes(it)
                } else {
                    view.showEmpty()
                }
            }
    }

    override fun searchNote(title: String) {
        disposable = repository.searchNote(title)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                if (it.isNotEmpty()) {
                    view.showAllNotes(it)
                } else {
                    view.showEmpty()
                }
            }
    }
}