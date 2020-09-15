package ru.fidean.testtask.Fragments

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment.findNavController
import ru.fidean.testtask.MainActivity
import ru.fidean.testtask.R
import ru.fidean.testtask.ViewModels.CheckViewModel

class Check : Fragment() {
    fun navigate(thisIsWeb: Boolean) {
        if (thisIsWeb) {
            Log.d("Answer", "Web Fragment")
            findNavController(this).navigate(CheckDirections.actionCheckToWebFragment())
        } else {
            findNavController(this).navigate(CheckDirections.actionCheckToGameFragment())
        }
    }

    companion object {
        fun newInstance() = Check()
    }

    private lateinit var viewModel: CheckViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.check_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CheckViewModel::class.java)
        val pref = activity!!.getSharedPreferences(
            getString(R.string.preference_file_key),
            Context.MODE_PRIVATE
        )
        if (pref.contains(getString(R.string.boolean_key))) {
            navigate(pref.getBoolean(getString(R.string.boolean_key), false))
        } else {
            viewModel.getAnswer()
        }
        viewModel.Answer.observe(viewLifecycleOwner, Observer {
            Log.d("Answer", "Get $it")
            val editor = pref.edit()
            editor.putBoolean(getString(R.string.boolean_key), it).apply()
            navigate(it)
        })

    }

}