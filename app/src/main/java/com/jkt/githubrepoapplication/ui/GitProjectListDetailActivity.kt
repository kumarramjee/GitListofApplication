package com.jkt.githubrepoapplication.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.jkt.githubrepoapplication.R
import com.jkt.githubrepoapplication.adapter.Adapter
import com.jkt.githubrepoapplication.bean.GitDetail
import com.jkt.githubrepoapplication.http.RetrofitClient
import com.jkt.githubrepoapplication.utility.Preferences

import kotlinx.android.synthetic.main.activity_git_project_list_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitProjectListDetailActivity : AppCompatActivity() {


    private var recyclerView: RecyclerView? = null
    private var imageModelArrayList: ArrayList<GitDetail>? = null
    private var adapter: Adapter? = null
    private lateinit var muserId: String

    lateinit var mPreferences: Preferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_project_list_detail)
        setSupportActionBar(toolbar)
        mPreferences = Preferences(this)

        muserId = intent!!.getStringExtra("Username")

        getApiCallForitsDetails(muserId)

    }



    private fun getApiCallForitsDetails(muserid: String) {

        RetrofitClient.instance.getListOfIndividualItems(
            muserid
        ).enqueue(object : Callback<GitDetail> {
            override fun onFailure(call: Call<GitDetail>, t: Throwable) {

            }

            override fun onResponse(call: Call<GitDetail>, response: Response<GitDetail>) {
                try {

                    Log.i("response", response.message())

                    if (response.isSuccessful) {
                      //  imageModelArrayList = response.body()


                        adapter = Adapter(this@GitProjectListDetailActivity, imageModelArrayList!!)
                        recyclerView!!.adapter = adapter

                    } else {
                        Toast.makeText(
                            this@GitProjectListDetailActivity,
                            "Not getting response",
                            Toast.LENGTH_SHORT
                        ).show()
                    }


                    //
//


                } catch (e: java.lang.Exception) {
                    Log.i("error", response.message())

                    e.printStackTrace()
                }

            }
        })

    }


}
