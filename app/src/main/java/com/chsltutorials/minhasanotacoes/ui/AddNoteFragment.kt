package com.chsltutorials.minhasanotacoes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.chsltutorials.minhasanotacoes.R
import com.chsltutorials.minhasanotacoes.util.bases.BaseFragment
import com.chsltutorials.minhasanotacoes.db.NoteDatabase
import com.chsltutorials.minhasanotacoes.entity.Note
import com.chsltutorials.minhasanotacoes.util.toast
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.coroutines.launch


class AddNoteFragment : BaseFragment() {

    private var note : Note? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.let {
            note = AddNoteFragmentArgs.fromBundle(it).note
            etTitle.setText(note?.title)
            etNote.setText(note?.note)
        }

        fabSave.setOnClickListener { view ->
            val noteTitle = etTitle.text.toString().trim()
            val noteBody = etNote.text.toString().trim()

            if (noteTitle.isEmpty()) {
                etTitle.error = "Título obrigatório"
                etTitle.requestFocus()
                return@setOnClickListener
            }
            if (noteBody.isEmpty()) {
                context?.toast("Corpo obrigatório")
                etNote.requestFocus()
                return@setOnClickListener
            }

            launch {
                context?.let {
                    val mNote = Note(noteTitle,noteBody)
                    if (note == null){
                        NoteDatabase(it).getNoteDao().addNote(mNote)
                        it.toast("Anotação salva")
                    }else{
                        mNote.id = note!!.id
                        NoteDatabase(it).getNoteDao().addNote(mNote)
                        it.toast("Mudanças salvas")
                    }
                    val action = AddNoteFragmentDirections.actionSaveNote()
                    Navigation.findNavController(view).navigate(action)
                }
            }
        }

    }



}
