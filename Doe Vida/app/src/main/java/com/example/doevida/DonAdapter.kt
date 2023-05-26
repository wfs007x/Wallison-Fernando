package com.example.doevida

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DonAdapter (private val empList: ArrayList<ModelDonate>) :
    RecyclerView.Adapter<DonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_itemdon, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DonAdapter.ViewHolder, position: Int) {
        val currentEmp = empList[position]
        holder.tvEmpName.text = currentEmp.txtNameDonat
    }

    override fun getItemCount(): Int {
        return empList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvEmpName: TextView = itemView.findViewById(R.id.tvEmpName)


    }
}