package com.mrz.gropietest.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.mrz.gropietest.R
import com.mrz.gropietest.databinding.ItemViewBinding
import com.mrz.gropietest.model.RetrofitBuilding
import com.xwray.groupie.Item
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.viewbinding.BindableItem

class GroupieAdapter(private val name: String,
                     private val poster: String) : BindableItem<ItemViewBinding>() {

    override fun initializeViewBinding(view: View): ItemViewBinding {
        return ItemViewBinding.bind(view)
    }

    override fun getLayout() = R.layout.item_view

    override fun bind(viewBinding: ItemViewBinding, position: Int) {
        viewBinding.tvText.text = name
        Glide.with(viewBinding.root)
            .load(RetrofitBuilding.BASE_URL_IMAGES + poster)
            .into(viewBinding.ivItem)
    }


}
