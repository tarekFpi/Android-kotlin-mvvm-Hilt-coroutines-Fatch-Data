package com.example.myhiltrepository.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhiltrepository.model.product
import com.example.myhiltrepository.model.productItem
import com.example.myhiltrepository.repository.productRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: productRepository) : ViewModel(){

    val productLiveData : LiveData<List<productItem>>
    get() = repository.itemlist

    val errorMessge : LiveData<String>
        get() = repository.errorMessage

    init {
        viewModelScope.launch {
            repository.getProduct()
        }
    }
}