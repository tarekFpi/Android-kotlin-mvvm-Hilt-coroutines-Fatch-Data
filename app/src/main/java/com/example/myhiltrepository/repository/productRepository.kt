package com.example.myhiltrepository.repository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myhiltrepository.model.productItem
import com.example.myhiltrepository.retrofit.FakerAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class productRepository @Inject constructor(private  val fakerAPI: FakerAPI){

  private var _productList = MutableLiveData<List<productItem>>()

  val  itemlist : LiveData<List<productItem>>
  get() = _productList

  val errorMessage = MutableLiveData<String>()

  fun  getProduct() {
    var result = fakerAPI.getProducts();

    result.enqueue(object : Callback<List<productItem>> {
      override fun onFailure(call: Call<List<productItem>>?, t: Throwable?) {

          errorMessage.postValue(t!!.message)

      }

      override fun onResponse(call: Call<List<productItem>>?, response: Response<List<productItem>>?) {
        _productList.value = response!!.body()
      }

    })

  }
}


