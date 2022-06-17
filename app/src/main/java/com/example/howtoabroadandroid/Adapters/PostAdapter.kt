package com.example.howtoabroadandroid.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.howtoabroadandroid.R
import com.example.howtoabroadandroid.model.PostModel
import com.example.howtoabroadandroid.model.PostsItem
import kotlinx.android.synthetic.main.post_item.view.*

class PostAdapter() : androidx.recyclerview.widget.ListAdapter<PostsItem, PostAdapter.viewHolder>(
    Diff()
) {

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        var current = getItem(position)

        holder.itemView.apply {

            userId.text = current.userId.toString()
            title.text = current.title
            body.text = current.body
            theId.text = current.id.toString()

        }
    }




}


class Diff() : DiffUtil.ItemCallback<PostsItem>() {
    override fun areItemsTheSame(oldItem: PostsItem, newItem: PostsItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PostsItem, newItem: PostsItem): Boolean {
        return oldItem == newItem
    }

}