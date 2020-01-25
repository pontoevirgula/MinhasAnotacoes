package com.chsltutorials.minhasanotacoes.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.chsltutorials.minhasanotacoes.R
import com.chsltutorials.minhasanotacoes.db.NoteDatabase
import com.chsltutorials.minhasanotacoes.util.bases.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch


class HomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rvNotes.setHasFixedSize(true)
        rvNotes.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)

        launch {
            context?.let {
                val notes = NoteDatabase(it).getNoteDao().getAllNotes()
                rvNotes.adapter = NoteAdapter(notes)
            }
        }

        fabAdd.setOnClickListener {
            val action = R.id.actionAddNote
            Navigation.findNavController(it).navigate(action)
        }
    }


}
