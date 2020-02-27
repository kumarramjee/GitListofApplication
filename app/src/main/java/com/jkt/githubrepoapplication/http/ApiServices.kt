package com.jkt.githubrepoapplication.http
import com.jkt.githubrepoapplication.bean.GitDetail
import retrofit2.Call
import retrofit2.http.*


interface ApiServices {

    @GET("users/{id}/repos")
    fun getListofProjectdetails(
      //  @Query("q") s: String
        @Path("id") s: String
    ): Call<GitDetail>


    @GET("/repos/{id}/spring-security-oauth")
    fun getListOfIndividualItems(
        //  @Query("q") s: String
        @Path("id") s: String
    ): Call<GitDetail>

}