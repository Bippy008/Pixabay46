package com.example.pixabay46

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.pixabay46.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val imagesList: MutableList<ImageModel> = mutableListOf()
    var imageAdapter = ImageAdapter(imagesList)
    var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.searchRecycler.adapter = imageAdapter
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            changePageBtn.setOnClickListener{
                ++page
                doRequest()
            }
            searchBtn.setOnClickListener{
                doRequest()
            }

            searchRecycler.addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                        doRequest()
                    }
                }
            })
        }
    }

    private fun ActivityMainBinding.doRequest() {
        App.api.getImages(keyWord = searchEd.text.toString(), page = page)
            .enqueue(object : Callback<PixaModel> {
                override fun onResponse(call: Call<PixaModel>, response: Response<PixaModel>) {
                    if (response.code() == 200) {
                        page++
                        for (item in response.body()?.hits!!) {
                            imagesList.add(item)
                        }
                        imageAdapter = ImageAdapter(imagesList)
                    }
                }

                override fun onFailure(call: Call<PixaModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}")
                }

            })
    }
}