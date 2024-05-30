package com.example.kotlinchat.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinchat.data.Message
import com.example.kotlinchat.data.User
import com.example.kotlinchat.objects.Injection
import com.example.kotlinchat.repositories.MessageRepository
import com.example.kotlinchat.repositories.UserRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class MessageViewModel : ViewModel() {

    private val messageRepository: MessageRepository = MessageRepository(Injection.instance())
    private val userRepository: UserRepository = UserRepository(
        FirebaseAuth.getInstance(),
        Injection.instance()
    )

    init {
        loadCurrentUser()
    }

    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> get() = _messages

    private val _roomId = MutableLiveData<String>()
    private val _currentUser = MutableLiveData<User>()
    val currentUser: LiveData<User> get() = _currentUser
    private fun loadCurrentUser() {
        viewModelScope.launch {
            userRepository.getCurrentUser().onSuccess { user ->
                _currentUser.value = user
            }
        }
    }

    fun loadMessages() {
        viewModelScope.launch {
            messageRepository.getChatMessages(_roomId.value ?: "") // Handle null roomId
                .collect { messages -> // Rename _messages to messages for clarity
                    _messages.value = messages // Use _messages for state flow
                }
        }
    }

    fun sendMessage(text: String) {
        if (_currentUser.value != null) {
            val message = Message(
                senderFirstName = _currentUser.value!!.firstName,
                senderId = _currentUser.value!!.email,
                text = text
            )
            viewModelScope.launch {
                messageRepository.sendMessage(_roomId.value.toString(), message.text)
                    .onSuccess {
                        loadMessages()
                    }
            }
        }
    }
    fun setRoomId(roomId: String) {
        _roomId.value = roomId
        loadMessages()
    }
}