package com.example.S8133149Assignment2.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.S8133149Assignment2.DetailActivity
import com.example.S8133149Assignment2.response.DashboardResponse
import com.example.S8133149Assignment2.R

// This is the adapter class. The recycler view uses this class to map the data with their respective id's.
class EntityAdapter(private val entities: DashboardResponse?) : RecyclerView.Adapter<EntityAdapter.EntityViewHolder>() {

    class EntityViewHolder(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        //Getting IDs
       val courseCode = itemView.findViewById<TextView>(R.id.courseCode)
        val courseName = itemView.findViewById<TextView>(R.id.courseName)
        val instructor = itemView.findViewById<TextView>(R.id.instructor)

        val button = itemView.findViewById<Button>(R.id.dashboardButton)
    }

    //Creating a container
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EntityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item,parent,false)

        return EntityViewHolder(view)
    }

    //Adding the data for the item
    override fun onBindViewHolder(
        holder: EntityViewHolder,
        position: Int
    ) {
        val entity = entities?.entities[position]
        holder.courseCode.text = entity?.courseCode
        holder.courseName.text = entity?.courseName
        holder.instructor.text = entity?.instructor


        //The button when clicked, navigates to detail activity alongside with certain values.
        holder.button.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("Code",holder.courseCode.text)
            intent.putExtra("Name",holder.courseName.text)
            intent.putExtra("Instructor",holder.instructor.text)
            intent.putExtra("Credits",entity?.credits)
            intent.putExtra("Description",entity?.description)

            //Start the activity
           holder.itemView.context.startActivity(intent)

       }


    }

    //How many items do we need for the recycler views.
    override fun getItemCount(): Int {
        return entities?.entities?.size ?: 0
    }


}