package ru.fidean.testtask.Fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.game_fragment.*
import ru.fidean.testtask.R
import ru.fidean.testtask.ViewModels.GameViewModel

class GameFragment : Fragment() {

    companion object {
        fun newInstance() = GameFragment()
    }

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.game_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        mainImage.setOnClickListener {
            viewModel.upScore()
        }
        upButton.setOnClickListener {
            viewModel.upPower()
        }
        viewModel.Score.observe(viewLifecycleOwner, Observer {
            scoreCount.setText("$it")
        })
        viewModel.UpPrise.observe(viewLifecycleOwner, Observer {
            upPrise.setText("$it")
        })
    }

}