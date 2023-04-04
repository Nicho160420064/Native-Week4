package com.ubaya.week4_160420064_c.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.week4_160420064_c.R
import com.ubaya.week4_160420064_c.model.Student
import com.ubaya.week4_160420064_c.util.loadImage
import java.lang.Integer.parseInt

class StudentListAdapter(val studenList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {
    class StudentViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.findViewById<TextView>(R.id.txtID).text = studenList[position].id
        holder.view.findViewById<TextView>(R.id.txtNama).text = studenList[position].name
        var imageView = holder.view.findViewById<ImageView>(R.id.imageView)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
        imageView.loadImage(studenList[position].photoUrl, progressBar)
        holder.view.findViewById<Button>(R.id.btnDetail).setOnClickListener{
            val action = StudentListFragmentDirections.actionStudentDetail(studenList[position].id.toString(),studenList[position].name.toString(),studenList[position].dob.toString(),studenList[position].phone.toString(),studenList[position].photoUrl.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }
    override fun getItemCount(): Int {
        return studenList.size
    }
    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }
}
