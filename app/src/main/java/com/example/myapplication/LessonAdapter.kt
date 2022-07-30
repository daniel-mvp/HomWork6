package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemRecyclerBinding

class LessonAdapter(val data : ArrayList<LessonModel>): RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder(ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size




    class LessonViewHolder(private val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(lessonModel: LessonModel) {

            binding.txtLesson.text = lessonModel.text
            Glide.with(binding.image).load(lessonModel.image).into(binding.image)
            val color = (Math.random() * 16777215).toInt() or (0xFF shl 24)
            binding.background.setBackgroundColor(color)
        }

    }
}