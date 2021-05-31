package com.debz.recyclerviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.debz.recyclerviews.databinding.TodoLayoutBinding

/* This adapter class' job is to create views for our recycler view and to set the contents of our
items accordingly.*/


class TodoAdapter (var todos:List<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {



        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.todo_layout, parent, false)
        // attachToRoot: false Does not attach the layout to root view which we inflate otherwise it will crash
        return TodoViewHolder(itemView)
        // This function will look always the same since we just want to inflate the layout file created for recycler view.
    }



    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        // Binds the data to ViewHolder
        val todox=todos[position]
        holder.itemView.apply {
            holder.tvTask.text= todox.title
            holder.cbTask.isChecked=todox.isChecked
        }

    }
    override fun getItemCount(): Int {
        // Returns the number of items in recycler view
        return todos.size
    }

    class TodoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvTask: TextView = itemView.findViewById(R.id.tvTask)
        val cbTask: CheckBox = itemView.findViewById(R.id.cbTask)
    }
    /* Each adapter for recycler view needs an inner class which is a view holder class which does as the
    name says. This class inherits from the recycler view
    To call the constructor of the ViewHolder() we need to pass the item view same as we passed in
    TodoViewHolder() */


}