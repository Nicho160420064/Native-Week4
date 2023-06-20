package com.ubaya.week4_160420064_c.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.week4_160420064_c.model.Student
import com.ubaya.week4_160420064_c.view.StudentDetailFragmentArgs
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope


class DetailViewModel: ViewModel() {
    val TAG = "volleytag"
    private var queue: RequestQueue? = null
    val studentLD = MutableLiveData<Student>()

    fun fetch(id:String,name:String,dob:String,phone:String,photoUrl:String) {
        val student1 = Student(id,name,dob,phone,photoUrl )
    }

}
