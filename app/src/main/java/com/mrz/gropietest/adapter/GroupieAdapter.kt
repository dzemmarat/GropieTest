package com.mrz.gropietest.adapter

import android.view.View
import com.mrz.gropietest.R
import com.mrz.gropietest.databinding.ItemViewBinding
import com.xwray.groupie.viewbinding.BindableItem

class GroupieAdapter(private val song: String) : BindableItem<ItemViewBinding>() {
    override fun initializeViewBinding(view: View): ItemViewBinding {
        return ItemViewBinding.bind(view)
    }
    override fun getLayout() = R.layout.item_view

    override fun bind(viewBinding: ItemViewBinding, position: Int) {
        viewBinding.tvText.text = song
    }

}
