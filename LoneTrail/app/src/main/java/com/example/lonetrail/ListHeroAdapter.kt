package com.example.lonetrail

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, photo) = listHero[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                when (position) {
                    0 -> { // Item 1
                        val intent = Intent(holder.itemView.context, ArchiveOne::class.java)
                        holder.itemView.context.startActivity(intent)
                    }
                    1 -> { // Item 2
                        val intent = Intent(holder.itemView.context, ArchiveTwo::class.java)
                        holder.itemView.context.startActivity(intent)
                    }
                    2 -> { // Item 3
                        val intent = Intent(holder.itemView.context, ArchiveThree::class.java)
                        holder.itemView.context.startActivity(intent)
                    }
                    3 -> { // Item 4
                        val intent = Intent(holder.itemView.context, ArchiveFour::class.java)
                        holder.itemView.context.startActivity(intent)
                    }
                    4 -> { // Item 5
                        val intent = Intent(holder.itemView.context, ArchiveFive::class.java)
                        holder.itemView.context.startActivity(intent)
                    }
                    5 -> { // Item 6
                        val intent = Intent(holder.itemView.context, ArchiveSIx::class.java)
                        holder.itemView.context.startActivity(intent)
                    }
                    6 -> { // Item 7
                        val intent = Intent(holder.itemView.context, ArchiveSeven::class.java)
                        holder.itemView.context.startActivity(intent)
                    }
                    7 -> { // Item 8
                        val intent = Intent(holder.itemView.context, ArchiveEight::class.java)
                        holder.itemView.context.startActivity(intent)
                    }
                    8 -> { // Item 9
                        val intent = Intent(holder.itemView.context, ArchiveNine::class.java)
                        holder.itemView.context.startActivity(intent)
                    }
                    9 -> { // Item 10
                        val intent = Intent(holder.itemView.context, ArchiveTen::class.java)
                        holder.itemView.context.startActivity(intent)
                    }
                    // ... other positions and activities
                    else -> {
                        // Handle invalid position, e.g., show a toast message
                        Toast.makeText(holder.itemView.context, "Invalid position", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}