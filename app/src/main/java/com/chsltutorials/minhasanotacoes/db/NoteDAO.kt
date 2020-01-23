package com.chsltutorials.minhasanotacoes.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.chsltutorials.minhasanotacoes.entity.Note


@Dao
interface NoteDAO {

    @Insert
    fun addNote(note : Note)

    @Query("SELECT * FROM note")
    fun getAllNotes() : List<Note>

    @Insert
    fun addMultipleNote(vararg note : Note)
}