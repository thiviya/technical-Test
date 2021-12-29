package com.trinitywizards.test.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.trinitywizards.utils.BindableAdapter
import org.koin.core.KoinComponent

object BindingUtils: KoinComponent {
    @BindingAdapter("loadRvData")
    @JvmStatic
    fun <T> loadRecyclerViewData(recyclerView: RecyclerView, items: List<T>?) {
        items?.let {
            if (recyclerView.adapter is BindableAdapter<*>) {
                (recyclerView.adapter as BindableAdapter<T>).setData(it)
            }
        }
    }

//    @BindingAdapter("refreshData")
//    @JvmStatic
//    fun <T> refreshRecyclerViewData(recyclerView: RecyclerView, item: LiveData<Suburb>) {
//        item?.let {
//            if (recyclerView.adapter is BindableAdapter<*>) {
//                (recyclerView.adapter as BindableAdapter<T>).refreshData()
//            }
//        }
//    }
}