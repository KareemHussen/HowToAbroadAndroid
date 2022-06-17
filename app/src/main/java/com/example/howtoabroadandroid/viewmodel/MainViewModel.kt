package com.example.howtoabroadandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.howtoabroadandroid.model.PostModel
import com.example.howtoabroadandroid.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(var repository: Repository) : ViewModel() {

    var mutableLiveData : MutableLiveData<PostModel> = MutableLiveData()

    fun getAllPosts(){
        viewModelScope.launch {
            mutableLiveData.value = repository.getAllPosts().body()
        }
    }



}