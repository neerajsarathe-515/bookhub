package com.neeraj.bookhub.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.neeraj.bookhub.R
import com.neeraj.bookhub.activity.DescriptionActivity
import com.neeraj.bookhub.model.Book
import com.squareup.picasso.Picasso

class DashboardRecyclerAdapter(val context : Context, val itemList: ArrayList<Book>) : RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {

    lateinit var txtBookName : TextView
    lateinit var txtPrice : TextView
    lateinit var imgBookImage : ImageView
    lateinit var txtRatings : TextView
    lateinit var txtAuthor : TextView

    class DashboardViewHolder(view: View): RecyclerView.ViewHolder(view){

        val txtBookName : TextView = view.findViewById(R.id.txtBookName)
        val txtPrice : TextView = view.findViewById(R.id.txtBookPrice)
        val imgBookImage : ImageView = view.findViewById(R.id.imgBookImage)
        val txtRatings : TextView = view.findViewById(R.id.txtBookRating)
        val txtAuthor : TextView = view.findViewById((R.id.txtBookAuthor))
        val llContent : LinearLayout = view.findViewById(R.id.llContent)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)

        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val book = itemList[position]
        holder.txtBookName.text = book.bookName
        holder.txtAuthor.text = book.bookAuthor
        holder.txtPrice.text = book.bookPrice
        holder.txtRatings.text = book.bookRating
        /*holder.imgBookImage.setImageResource(book.bookImage)*/
        Picasso.get().load(book.bookImage).error(R.drawable.default_book_cover).into(holder.imgBookImage);

        holder.llContent.setOnClickListener{
            val intent = Intent(context, DescriptionActivity::class.java)
            intent.putExtra("book_id",book.bookId)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

}