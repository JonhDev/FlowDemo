package com.jonhbravo.flowdemo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.jonhbravo.flowdemo.databinding.ActivityMainBinding
import com.jonhbravo.flowdemo.models.FlowState
import com.jonhbravo.flowdemo.models.ApiModel
import com.jonhbravo.flowdemo.views.UiView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: FlowViewModel by viewModels()
    private val viewAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadContent()
    }

    private fun loadContent() {
        viewModel.getData().observe(this) {
            when (it.state) {
                FlowState.State.SUCCESS -> showListIfAvailable(it.data)
            }
        }
    }

    private fun showListIfAvailable(data: ApiModel?) {
        data?.let {
            viewAdapter.clear()
            viewAdapter.addAll(it.data.map { text ->
                UiView(text)
            })
            binding.recyclerViewContent.adapter = viewAdapter
        }
    }
}