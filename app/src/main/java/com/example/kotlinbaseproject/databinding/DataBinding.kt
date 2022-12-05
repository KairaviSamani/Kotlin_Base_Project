package com.example.kotlinbaseproject.databinding

import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinbaseproject.adapter.ChatAdapter
import com.example.kotlinbaseproject.model.Chat
import com.example.kotlinbaseproject.model.MessageType
import com.example.kotlinbaseproject.utils.AppLog
import com.example.kotlinbaseproject.viewmodel.ChatViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView

/**
 * This class is used to bind data in xml
 */
@BindingAdapter("editText", "messageType", "viewModel")
fun setEndIconClickListener(
    textInputLayout: TextInputLayout,
    textInputEditText: TextInputEditText,
    messageType: MessageType,
    chatViewModel: ChatViewModel
) {
    textInputLayout.setEndIconOnClickListener {
        if (textInputEditText.text!!.isNotEmpty()) {
            chatViewModel.addMessage(textInputEditText.text.toString(), messageType)
        }
        textInputEditText.text?.clear()
    }

}

@BindingAdapter("chatList")
fun setAdapter(recyclerView: RecyclerView, chatList: List<Chat>?) {
    recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    AppLog.d("Data", chatList.toString())
    if (chatList != null && chatList.isNotEmpty()) {
        val chatAdapter = ChatAdapter(chatList, recyclerView.context)
        recyclerView.adapter = chatAdapter
        recyclerView.scrollToPosition(chatList.size - 1)
    }
}

@BindingAdapter("gravity")
fun setGravity(materialTextView: MaterialTextView, gravity: Int) {
    val params = (materialTextView.layoutParams as LinearLayout.LayoutParams).apply {
        this.gravity = gravity
    }
    materialTextView.layoutParams = params
}
