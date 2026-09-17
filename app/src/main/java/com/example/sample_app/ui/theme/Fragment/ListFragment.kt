package com.example.sample_app.ui.theme.Fragment

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sample_app.R
import com.example.sample_app.ui.theme.Adapter.GrideAdapter
import com.example.sample_app.ui.theme.Adapter.Listadapter
import com.example.sample_app.ui.theme.viewmodels.MiniAppViewmodel

class ListFragment : Fragment(R.layout.fragment_list) {

    val viewmodel: MiniAppViewmodel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val progressBar = view.findViewById<ProgressBar>(R.id.ProgressBar)
        val searchView = view.findViewById<SearchView>(R.id.search_view)


        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewmodel.UiState.observe(viewLifecycleOwner) { responsefromviewmodel ->

            when (responsefromviewmodel) {
                is MiniAppViewmodel.uistate.isLoading -> {
                    progressBar.visibility = View.VISIBLE
                }

                is MiniAppViewmodel.uistate.Sucess -> {

                    val datalist = responsefromviewmodel.ApiresLIst

                    val adapter = Listadapter(datalist)
                    recyclerView.adapter = adapter

                    progressBar.visibility = View.GONE

                    // SearchView

                    searchView.setOnQueryTextListener(

                        object : SearchView.OnQueryTextListener {

                            override fun onQueryTextChange(newText: String?): Boolean {
                                adapter.filter(newText.orEmpty())
                                return true
                            }

                            override fun onQueryTextSubmit(query: String?): Boolean {
                                return false
                            }

                        }
                    )

                }

                is MiniAppViewmodel.uistate.Eror -> {
                    //
                }

            }


        }


    }

}