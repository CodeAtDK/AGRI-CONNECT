package com.example.agriconnect.chatbot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentChatBotBinding
import com.google.ai.client.generativeai.Chat
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class Chat_Bot : Fragment() {

    private var _binding : FragmentChatBotBinding? = null
    private val binding get() = _binding!!

    lateinit var chat: Chat
    var stringBuilder: StringBuilder = java.lang.StringBuilder()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentChatBotBinding.inflate(inflater,container,false)

       // editTextInput = findViewById(R.id.editTextInput)
       // editTextOutput = findViewById(R.id.editTextOutput)

        val generativeModel = GenerativeModel(
            // For text-only input, use the gemini-pro model
            modelName = "gemini-pro",
            // Access your API key as a Build Configuration variable (see "Set up your API key" above)
            apiKey = "API KEY"
        )
        chat = generativeModel.startChat(
            history = listOf(
                content(role = "user") { text("Hello, I have 2 dogs in my house.") },
                content(role = "model") { text("Great to meet you. What would you like to know?") }
            )
        )
        stringBuilder.append("Hello, I am Your Chat bot.\n\n")
        stringBuilder.append("You can ask me any Thing\n\n")

        binding.editTextOutput.setText(stringBuilder.toString())

        binding.button.setOnClickListener{
            binding.button.isEnabled = false
            buttonSendChat()

        }

        return binding.root
        //return inflater.inflate(R.layout.fragment_chat__bot, container, false)
    }

    public fun buttonSendChat(){
        stringBuilder.append(binding.editTextInput.text.toString() + "\n\n")
        MainScope().launch {
            var result = chat.sendMessage(binding.editTextInput.text.toString())
            stringBuilder.append(result.text + "\n\n")

            binding.editTextOutput.setText(stringBuilder.toString())
            binding.editTextInput.setText("")
            binding.button.isEnabled = true
        }
    }

}