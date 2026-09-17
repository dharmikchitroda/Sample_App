package com.example.sample_app.ui.theme.Fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sample_app.R
import com.example.sample_app.ui.theme.Adapter.GrideAdapter
import com.example.sample_app.ui.theme.viewmodels.MiniAppViewmodel
import kotlin.getValue

class HomeFragment : Fragment(R.layout.fragment_home) {

    val viewmodel: MiniAppViewmodel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)


        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewGrid)
        val progressBar = view.findViewById<ProgressBar>(R.id.ProgressBar2)

        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)



        viewmodel.UiState.observe(viewLifecycleOwner) { responsefromviewmodel ->

            when (responsefromviewmodel) {
                is MiniAppViewmodel.uistate.isLoading -> {
                    progressBar.visibility = View.VISIBLE
                }

                is MiniAppViewmodel.uistate.Sucess -> {
                    val datalist = responsefromviewmodel.ApiresLIst
                    recyclerView.adapter = GrideAdapter(datalist)
                    progressBar.visibility = View.GONE
                }

                is MiniAppViewmodel.uistate.Eror -> {
                    //
                }

            }


        }


    }
    }


//  if check fragment lifecyle you can view inside log using tag
/* private val TAG = "FragmentLifecycle"

override fun onAttach(context: Context) {
    super.onAttach(context)
    Log.d(TAG, "onAttach")
}
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.d(TAG, "onCreate")
}
override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
): View? {
    Log.d(TAG, "onCreateView")
    return inflater.inflate(R.layout.fragment_home, container, false)
}
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    Log.d(TAG, "onViewCreated")
    super.onViewCreated(view, savedInstanceState)
}
override fun onStart() {
    super.onStart()
    Log.d(TAG, "onStart")
}
override fun onResume() {
    super.onResume()
    Log.d(TAG, "onResume")
}
override fun onPause() {
    super.onPause()
    Log.d(TAG, "onPause")
}
override fun onStop() {
    super.onStop()
    Log.d(TAG, "onStop")
}
override fun onDestroyView() {
    super.onDestroyView()
    Log.d(TAG, "onDestroyView")
}
override fun onDestroy() {
    super.onDestroy()
    Log.d(TAG, "onDestroy")
}
override fun onDetach() {
    super.onDetach()
    Log.d(TAG, "onDetach")
} */