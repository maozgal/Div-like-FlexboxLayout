package com99.example.gal.flexboxlayout

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Button

import androidx.recyclerview.widget.RecyclerView

import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent

import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val layoutManager = FlexboxLayoutManager(this)
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.CENTER
        recyclerView.layoutManager = layoutManager

        val divLikeContent = ArrayList<String>()
        divLikeContent.add("Route")
        divLikeContent.add("No calls during the ride")
        divLikeContent.add("Smell")
        divLikeContent.add("Less talk")
        divLikeContent.add("Safety")

        val adapter = DivLikeAdapter(divLikeContent)

        recyclerView.adapter = adapter

        val addButton = findViewById<Button>(R.id.add_item_button)
        addButton.setOnClickListener {
            divLikeContent.add(generateRandonText())
            recyclerView.adapter = adapter
        }
    }

    private fun generateRandonText(): String {
        val sb = StringBuilder()
        for (i in 1 + (Math.random() * 20).toInt() downTo 1) {
            sb.append("a")
        }
        return sb.toString()
    }
}
