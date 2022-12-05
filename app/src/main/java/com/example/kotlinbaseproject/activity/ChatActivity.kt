package com.example.kotlinbaseproject.activity

import android.os.Bundle
import androidx.activity.viewModels
import com.example.kotlinbaseproject.databinding.ActivityChatBinding
import com.example.kotlinbaseproject.viewmodel.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatActivity : BaseActivity() {
    private lateinit var binding: ActivityChatBinding
    private val chatViewModel: ChatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        binding.lifecycleOwner = this@ChatActivity
        binding.chatViewModel = chatViewModel
    }
}