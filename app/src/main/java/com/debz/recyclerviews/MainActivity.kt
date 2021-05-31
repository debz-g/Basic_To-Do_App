package com.debz.recyclerviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.debz.recyclerviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var todoList= mutableListOf(
            Todo("Follow android devs",false),
            Todo("Research about recycler view", false),
            Todo("Issue with Recycler View Adapter",false),
            Todo("ViewBinding not working with Adapter Class",false),
            Todo("RecyclerView is a pain in the ass",false)
        )

        val adapter = TodoAdapter(todoList)
        binding.rvTodo.adapter = adapter
        binding.rvTodo.layoutManager = LinearLayoutManager(this)

        binding.btnTodo.setOnClickListener {
            val title = binding.etTodo.text.toString()
            val todo = Todo(title, false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}