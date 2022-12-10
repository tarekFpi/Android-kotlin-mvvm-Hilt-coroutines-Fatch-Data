package com.example.myhiltrepository

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.myhiltrepository.di.FackerApplication
import com.example.myhiltrepository.factroy.MainViewModelFactory
import com.example.myhiltrepository.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

   lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory;

       private val textView: TextView
      get() = findViewById(R.id.text_viewbody)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as FackerApplication).applicationComponent.inject(this);
        mainViewModel= ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java);

        mainViewModel.productLiveData.observe(this, Observer {

           textView.text = it.joinToString {
                x-> x.title +"\n\n"
            }
        })

        mainViewModel.errorMessge.observe(this, Observer {
            Toast.makeText(applicationContext, "error:"+it.toString(), Toast.LENGTH_SHORT).show()
        })
    }
}