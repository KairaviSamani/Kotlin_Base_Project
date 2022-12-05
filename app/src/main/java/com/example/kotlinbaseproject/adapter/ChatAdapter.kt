package com.example.kotlinbaseproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbaseproject.databinding.ItemChatBinding
import com.example.kotlinbaseproject.model.Chat


class ChatAdapter(private val chatList: List<Chat>, private val context: Context) :
    RecyclerView.Adapter<ChatAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapterViewHolder {
        val binding = ItemChatBinding.inflate(LayoutInflater.from(context), parent, false)
        return ChatAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatAdapterViewHolder, position: Int) {
        val chat = chatList[position]
        holder.binding.chat = chat
    }

    override fun getItemCount() = chatList.size
}

class ChatAdapterViewHolder(val binding: ItemChatBinding) :
    RecyclerView.ViewHolder(binding.root)