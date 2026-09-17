package com.example.sample_app.ui.theme.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sample_app.databinding.CardBinding
import com.example.sample_app.ui.theme.model.response.User

// oop used here : primary constructor call will object creation time
class SimpleAdapter(
    private var dataset: List<User>,
    // oop used here : extend cardclickinterface interface without constructor
) : RecyclerView.Adapter<SimpleAdapter.MyViewHolder>() {

    class MyViewHolder( val binding : CardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder (
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        val binding = CardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder( binding )

    }

    // oop used here :override onBindViewHolder and can modify according my needs
    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val currentstudentdata = dataset[position]

        holder.binding.tvName.text = currentstudentdata.Name
        holder.binding.tvEmail.text = currentstudentdata.email
        holder.binding.tvPhone.text = currentstudentdata.mobile
    }

    override fun getItemCount( ): Int {
        return dataset.size
    }

}