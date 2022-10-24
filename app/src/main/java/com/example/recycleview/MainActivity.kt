package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.adapter.ItemAdapter
import com.example.recycleview.helper.ItemClickListener

class MainActivity : AppCompatActivity() {
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var recyclerView: RecyclerView
    private val studentList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv)
        itemAdapter = ItemAdapter(studentList(), itemClick)

        recyclerView.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(this@MainActivity,)
        }
        itemAdapter.onClick = {text ->
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }

    private fun studentList(): ArrayList<String> {
        studentList.add("Samandar")
        studentList.add("Muhammadali")
        studentList.add("Samandar")
        studentList.add("Samandar")
        studentList.add("Samandar")
        studentList.add("Samandar")
        studentList.add("Akbarjon")
        studentList.add("Samandar")
        studentList.add("Samandar")
        studentList.add("Fayzullo")
        studentList.add("Samandar")
        return studentList
    }
    private val itemClick = object  : ItemClickListener{
        override fun onClick(text: String) {
            Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
        }

    }
}