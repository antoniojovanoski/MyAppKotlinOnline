package com.android.gsixacademy.myappkotlinonline

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_todo_list_layout.*

class TodoListActivity : AppCompatActivity() {
    var todoList = arrayListOf<String>("Example")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list_layout)
        var arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoList)
        list_view_todo.adapter = arrayAdapter
        button_add_item.setOnClickListener {
            if (edit_text_todo_value.text.isNotEmpty())
                todoList.add(edit_text_todo_value.text.toString())
            var arrayAdapter =
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoList)
            list_view_todo.adapter = arrayAdapter
            edit_text_todo_value.setText("")
        }

        list_view_todo.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(applicationContext, todoList[i], Toast.LENGTH_LONG).show()
        }
        list_view_todo.setOnItemLongClickListener { adapterView, view, i, l ->
            var itemText = todoList[i]
            todoList.remove(itemText)
            var arrayAdapter =
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoList)
            list_view_todo.adapter = arrayAdapter
            Toast.makeText(applicationContext, "${itemText} is removed", Toast.LENGTH_LONG).show()
            return@setOnItemLongClickListener (true)
        }
    }
}