package com.chsltutorials.minhasanotacoes.db

import androidx.room.*
import com.chsltutorials.minhasanotacoes.entity.Note


@Dao
interface NoteDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note : Note)

    @Query("SELECT * FROM note ORDER BY id DESC")
    suspend fun getAllNotes() : List<Note>

    @Insert
    suspend fun addMultipleNote(vararg note : Note)

    @Update
    suspend fun updateNote(note : Note)
}