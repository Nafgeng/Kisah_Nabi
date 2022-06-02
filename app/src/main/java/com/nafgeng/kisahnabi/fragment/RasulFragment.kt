package com.nafgeng.kisahnabi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.nafgeng.kisahnabi.adapter.RasulAdapter
import com.nafgeng.kisahnabi.databinding.FragmentRasulBinding
import com.nafgeng.kisahnabi.network.ResponseNabiItem
import com.nafgeng.kisahnabi.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RasulFragment : Fragment() {

    private lateinit var binding: FragmentRasulBinding
    val adapterRasul = RasulAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRasulBinding.inflate(inflater,container,false)

        with(binding) {
            binding.recyclerrasul.adapter = adapterRasul
            recyclerrasul.setHasFixedSize(true)
            recyclerrasul.layoutManager = LinearLayoutManager(context)
        }

        val call = RetrofitService.getService().getDataRasul()
        call.enqueue(object : Callback<List<ResponseNabiItem>>{
            override fun onResponse(
                call: Call<List<ResponseNabiItem>>,
                response: Response<List<ResponseNabiItem>>
            ) {
                val listData = response.body()!!
                listData.let { it.let { it1 -> adapterRasul.addDataRasul(it1) } }
            }

            override fun onFailure(call: Call<List<ResponseNabiItem>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


        return binding.root
    }
}