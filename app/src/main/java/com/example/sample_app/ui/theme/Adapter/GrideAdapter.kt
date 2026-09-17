package com.example.sample_app.ui.theme.Adapter

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sample_app.R
import com.example.sample_app.ui.theme.model.CharacterResponse

class GrideAdapter(private var dataList: List<CharacterResponse>) :
    RecyclerView.Adapter<GrideAdapter.GridViewHolder>() {
    class GridViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup, // RecyclerView khud hai (jisme items add honge)
        viewType: Int
    ): GridViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.gridecard, parent, false)
        return GridViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(
        holder: GridViewHolder,
        position: Int
    ) {
        val currentuser = dataList[position]

        holder.view.findViewById<TextView>(R.id.tvName).text = currentuser.name
        holder.view.findViewById<TextView>(R.id.tvGender).text = currentuser.gender
        holder.view.findViewById<TextView>(R.id.tvStatus).text = currentuser.status

        val shape = holder.view.findViewById<View>(R.id.tvStatusIcon)
        val Statustxt = holder.view.findViewById<TextView>(R.id.tvStatus)
        val imageview= holder.view.findViewById<ImageView>(R.id.ivCharacterimage)


        // set dynamic status color
        val redColor = ContextCompat.getColor(holder.view.context, R.color.red)
        val tealColor = ContextCompat.getColor(holder.view.context, R.color.teal_700)
        val greenColor = ContextCompat.getColor(holder.view.context, R.color.green)

        when (currentuser.status?.lowercase()) {
            "dead" -> {
                Statustxt.setTextColor(redColor) //  FIXED
                shape.backgroundTintList = ColorStateList.valueOf(redColor)
            }

            "unknown" -> {
                Statustxt.setTextColor(tealColor) //  FIXED
                shape.backgroundTintList = ColorStateList.valueOf(tealColor)
            }

            else -> {
                Statustxt.setTextColor(greenColor) //  FIXED
                shape.backgroundTintList = ColorStateList.valueOf(greenColor)
            }
        }

        // Imageloader Glide
        Glide.with(holder.itemView.context)
            .load(currentuser.image)
            .placeholder(R.drawable.loading)
            .error(R.drawable.loading_error_icon)
            .into(imageview)

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
