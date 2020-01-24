package com.chsltutorials.minhasanotacoes.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.chsltutorials.minhasanotacoes.R
import com.chsltutorials.minhasanotacoes.util.bases.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fabAdd.setOnClickListener {
            val action = R.id.actionAddNote
            Navigation.findNavController(it).navigate(action)
        }
    }


}
