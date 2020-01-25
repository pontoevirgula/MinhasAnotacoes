package com.chsltutorials.minhasanotacoes.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.chsltutorials.minhasanotacoes.entity.Note


@Dao
interface NoteDAO {

    @Insert
    suspend fun addNote(note : Note)

    @Query("SELECT * FROM note ORDER BY id DESC")
    suspend fun getAllNotes() : List<Note>

    @Insert
    suspend fun addMultipleNote(vararg note : Note)
}