package com.alemi.cleannotes.business.interactors.notelist

import com.alemi.cleannotes.business.interactors.common.DeleteNote
import com.alemi.cleannotes.framework.presentation.notelist.state.NoteListViewState


// Use cases
class NoteListInteractors (
    val insertNewNote: InsertNewNote,
    val deleteNote: DeleteNote<NoteListViewState>,
    val searchNotes: SearchNotes,
    val getNumNotes: GetNumNotes,
    val restoreDeletedNote: RestoreDeletedNote,
    val deleteMultipleNotes: DeleteMultipleNotes,
    val insertMultipleNotes: InsertMultipleNotes // for testing
)














