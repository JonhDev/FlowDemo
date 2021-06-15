package com.jonhbravo.flowdemo.views

import android.view.View
import com.jonhbravo.flowdemo.R
import com.jonhbravo.flowdemo.databinding.UiViewBinding
import com.xwray.groupie.viewbinding.BindableItem

class UiView(private val text: String) : BindableItem<UiViewBinding>() {

    override fun bind(viewBinding: UiViewBinding, position: Int) {
        viewBinding.textViewItem.text = text
    }

    override fun getLayout() = R.layout.ui_view

    override fun initializeViewBinding(view: View) = UiViewBinding.bind(view)
}