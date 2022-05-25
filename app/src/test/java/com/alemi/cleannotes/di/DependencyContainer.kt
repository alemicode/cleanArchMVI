package com.alemi.cleannotes.di

import com.alemi.cleannotes.business.data.NoteDataFactory
import com.alemi.cleannotes.business.data.cache.FakeNoteCacheDataSourceImpl
import com.alemi.cleannotes.business.data.cache.abstraction.NoteCacheDataSource
import com.alemi.cleannotes.business.data.network.FakeNoteNetworkDataSourceImpl
import com.alemi.cleannotes.business.data.network.abstraction.NoteNetworkDataSource
import com.alemi.cleannotes.business.domain.model.Note
import com.alemi.cleannotes.business.domain.model.NoteFactory
import com.alemi.cleannotes.business.domain.util.DateUtil
import com.alemi.cleannotes.util.isUnitTest
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class DependencyContainer {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss a", Locale.ENGLISH)
    val dateUtil =
        DateUtil(dateFormat)
    lateinit var noteNetworkDataSource: NoteNetworkDataSource
    lateinit var noteCacheDataSource: NoteCacheDataSource
    lateinit var noteFactory: NoteFactory
    lateinit var noteDataFactory: NoteDataFactory

    init {
        isUnitTest = true // for Logger.kt
    }

    fun build() {
        this.javaClass.classLoader?.let { classLoader ->
            noteDataFactory = NoteDataFactory(classLoader)
        }
        noteFactory = NoteFactory(dateUtil)
        noteNetworkDataSource = FakeNoteNetworkDataSourceImpl(
            notesData = noteDataFactory.produceHashMapOfNotes(
                noteDataFactory.produceListOfNotes()
            ),
            deletedNotesData = HashMap(),
            dateUtil = dateUtil
        )
        noteCacheDataSource = FakeNoteCacheDataSourceImpl(
            notesData = noteDataFactory.produceHashMapOfNotes(
                noteDataFactory.produceListOfNotes()
            ),
            dateUtil = dateUtil
        )
    }

}

















