package com.ubaya.week4_160420064_c.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.week4_160420064_c.R
import com.ubaya.week4_160420064_c.viewmodel.DetailViewModel

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }
    fun observeViewModel() {
        viewModel.studentsLD.observe(viewLifecycleOwner, Observer {
            val id = view?.findViewById<EditText>(R.id.txtStudentID)
            val name = view?.findViewById<EditText>(R.id.txtStudentName)
            val bod= view?.findViewById<EditText>(R.id.txtBOD)
            val phone = view?.findViewById<EditText>(R.id.txtPhone)
            val image = view?.findViewById<ImageView>(R.id.imageView2)
            id?.setText(it.get(1).toString())
            name?.setText(it.get(2).toString())
            bod?.setText(it.get(3).toString())
            phone?.setText(it.get(4).toString())

        })

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(StudentDetailFragmentArgs.fromBundle(requireArguments()).id)
        observeViewModel()
    }

}