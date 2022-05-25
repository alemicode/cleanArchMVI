package com.alemi.cleannotes.framework.presentation.notedetail.state

import com.alemi.cleannotes.business.domain.model.Note
import com.alemi.cleannotes.business.domain.state.StateEvent
import com.alemi.cleannotes.business.domain.state.StateMessage


sealed class NoteDetailStateEvent: StateEvent {


    class UpdateNoteEvent: NoteDetailStateEvent(){

        override fun errorInfo(): String {
            return "Error updating note."
        }

        override fun eventName(): String {
            return "UpdateNoteEvent"
        }

        override fun shouldDisplayProgressBar() = true
    }

    class DeleteNoteEvent(
        val note: Note
    ): NoteDetailStateEvent(){

        override fun errorInfo(): String {
            return "Error deleting note."
        }

        override fun eventName(): String {
            return "DeleteNoteEvent"
        }

        override fun shouldDisplayProgressBar() = true
    }

    class CreateStateMessageEvent(
        val stateMessage: StateMessage
    ): NoteDetailStateEvent(){

        override fun errorInfo(): String {
            return "Error creating a new state message."
        }

        override fun eventName(): String {
            return "CreateStateMessageEvent"
        }

        override fun shouldDisplayProgressBar() = false
    }

}




















