package com.chsltutorials.minhasanotacoes.ui

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.chsltutorials.minhasanotacoes.R
import com.chsltutorials.minhasanotacoes.db.NoteDatabase
import com.chsltutorials.minhasanotacoes.entity.Note
import kotlinx.android.synthetic.main.fragment_add_note.*


class AddNoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fabSave.setOnClickListener {
            val noteTitle = etTitle.toString().trim()
            val noteBody = etNote.toString().trim()

            if (noteTitle.isEmpty()) {
                etTitle.error = "Título obrigatório"
                etTitle.requestFocus()
                return@setOnClickListener
            }
            val note = Note(noteTitle,noteBody)
            saveNote(note)
        }

    }

    private fun saveNote(note: Note){
        class SaveNote : AsyncTask<Void, Void, Void>(){
            override fun doInBackground(vararg params: Void?): Void? {
                NoteDatabase(activity!!).getNoteDao().addNote(note)
                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                Toast.makeText(activity!!,"Anotação salva", Toast.LENGTH_SHORT).show()
            }

        }
        SaveNote().execute()
    }


}
