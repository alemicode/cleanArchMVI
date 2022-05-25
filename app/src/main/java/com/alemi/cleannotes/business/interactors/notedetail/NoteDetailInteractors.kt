package com.alemi.cleannotes.business.interactors.notedetail

import com.alemi.cleannotes.business.interactors.common.DeleteNote
import com.alemi.cleannotes.framework.presentation.notedetail.state.NoteDetailViewState

// Use cases
class NoteDetailInteractors (
    val deleteNote: DeleteNote<NoteDetailViewState>,
    val updateNote: UpdateNote
)














