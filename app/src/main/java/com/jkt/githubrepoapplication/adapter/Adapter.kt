package com.jkt.githubrepoapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.jkt.githubrepoapplication.R
import com.jkt.githubrepoapplication.bean.GitDetail
import com.jkt.githubrepoapplication.ui.GitProjectListActivtiy
import com.jkt.githubrepoapplication.utility.Preferences
import java.util.*


class Adapter(ctx: Context, private val imageModelArrayList: ArrayList<GitDetail>) :
    RecyclerView.Adapter<Adapter.MyViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(ctx)
    lateinit var mPreferences: Preferences


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.MyViewHolder {

        val view = inflater.inflate(R.layout.rv_item, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.MyViewHolder, position: Int) {

        holder.time.setText(imageModelArrayList[position].name)
        holder.fullname.setText(imageModelArrayList[position].fullName)
        holder.id.setText(imageModelArrayList[position].id)




        holder.rootlayout.setOnClickListener {

           // val intent = Intent(this, GitProjectListActivtiy::class.java)
          //  startActivity(intent)


        }
    }

    override fun getItemCount(): Int {
        return imageModelArrayList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var time: TextView

        var iv: ImageView
        var fullname: TextView
        var id: TextView
        var rootlayout: LinearLayout

        init {


            rootlayout = itemView.findViewById(R.id.root_layout) as LinearLayout
            time = itemView.findViewById(R.id.tv) as TextView
            fullname = itemView.findViewById(R.id.fromto) as TextView
            id = itemView.findViewById(R.id.id) as TextView

            iv = itemView.findViewById(R.id.iv) as ImageView
        }

    }
}
