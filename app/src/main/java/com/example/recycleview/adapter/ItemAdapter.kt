package com.example.recycleview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.R
import com.example.recycleview.helper.ItemClickListener

class ItemAdapter(
    private val studentList: List<String>,
    private val itemClickListener: ItemClickListener

): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    lateinit var onClick: (text: String) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(studentList[position])

    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    inner class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val textView: TextView = view.findViewById(R.id.textView )
        fun bind(text: String){
            textView.text = text

            itemView.setOnClickListener {
                onClick.invoke(text)
            }

        }
    }
}