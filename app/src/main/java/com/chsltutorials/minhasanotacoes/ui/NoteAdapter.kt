package com.chsltutorials.minhasanotacoes.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chsltutorials.minhasanotacoes.R
import com.chsltutorials.minhasanotacoes.entity.Note
import kotlinx.android.synthetic.main.adapter_note_item.view.*

class NoteAdapter(private val notes: List<Note>) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_note_item, parent, false)
        )
    }
    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.view.tvTitle.text = notes[position].title
        holder.view.tvNote.text = notes[position].note
    }

    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}