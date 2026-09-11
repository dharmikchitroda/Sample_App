package com.example.sample_app.ui.theme

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sample_app.databinding.CardBinding
import com.example.sample_app.ui.theme.`interface`.cardclickinterface
import com.example.sample_app.ui.theme.model.response.User


import com.example.sample_app.ui.theme.model.Studentdata

class adapter(
    private var dataset: List<User>,
    var listner: cardclickinterface
) : RecyclerView.Adapter<adapter.MyViewHolder>() {

    class MyViewHolder(val binding: CardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = CardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val currentstudentdata = dataset[position]
        holder.binding.tvName.text = currentstudentdata.Name
        holder.binding.tvEmail.text = currentstudentdata.email
        holder.binding.tvPhone.text = currentstudentdata.mobile

        holder.binding.root.setOnClickListener {
            listner.onStudentClick(
                Studentdata(
                    name = currentstudentdata.Name,
                    email = currentstudentdata.email,
                    mobile = currentstudentdata.mobile
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    // NEW
    fun updateList(newList: List<User>) {
        dataset = newList
        notifyDataSetChanged()
    }
}
