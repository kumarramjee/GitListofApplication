package com.jkt.githubrepoapplication.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jkt.githubrepoapplication.R
import com.jkt.githubrepoapplication.adapter.Adapter
import com.jkt.githubrepoapplication.bean.GitDetail
import com.jkt.githubrepoapplication.http.RetrofitClient
import com.jkt.githubrepoapplication.utility.Preferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitProjectListActivtiy : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var gitDetails: ArrayList<GitDetail>? = null
    private var adapter: Adapter? = null
    private lateinit var muserId: String

    lateinit var mPreferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_project_list_activtiy)
        //  setSupportActionBar(toolbar)
        recyclerView = findViewById<RecyclerView>(R.id.category_recycler)

        mPreferences = Preferences(this)



        muserId = intent!!.getStringExtra("Username")
        mPreferences.save(getString(R.string.UserName), muserId.toString())



        recyclerView!!.layoutManager =
            LinearLayoutManager(this.applicationContext, LinearLayoutManager.VERTICAL, false)

        callApiForGettingListOfUser(muserId)


    }

    private fun callApiForGettingListOfUser(muserid: String) {

        RetrofitClient.instance.getListofProjectdetails(
            muserid
        ).enqueue(object : Callback<GitDetail> {
            override fun onFailure(call: Call<GitDetail>, t: Throwable) {

            }

            override fun onResponse(call: Call<GitDetail>, response: Response<GitDetail>) {
                try {

                    Log.i("response", response.message())

                    if (response.isSuccessful) {
                      //  gitDetails = response.body()


                        adapter = Adapter(this@GitProjectListActivtiy, gitDetails!!)
                        recyclerView!!.adapter = adapter

                    } else {
                        Toast.makeText(
                            this@GitProjectListActivtiy,
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