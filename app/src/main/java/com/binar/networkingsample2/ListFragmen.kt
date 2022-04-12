package com.binar.networkingsample2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.networkingsample2.adapter.CarAdapter
import com.binar.networkingsample2.databinding.FragmentListBinding
import com.binar.networkingsample2.model.GetAllCarResponseItem
import com.binar.networkingsample2.network.CarsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListFragmen : Fragment() {
    private var binding: FragmentListBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchAllData()
    }

    private fun fetchAllData() {
        CarsApi.instance.getAllCar()
            .enqueue(object : Callback<List<GetAllCarResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetAllCarResponseItem>>,
                    response: Response<List<GetAllCarResponseItem>>
                ) {
                    val body = response.body()
                    val code = response.code()
                    body?.let { showList(it) }
                }

                override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {

                }
            })

    }

    private fun showList(data: List<GetAllCarResponseItem>?) {
        val adapter = CarAdapter(object : CarAdapter.OnClickListener{
            override fun onClickItem(data: GetAllCarResponseItem) {
                val carName = data.name
                val carPrice = data.price
                findNavController().navigate(
                    ListFragmenDirections.actionListFragmenToDetailFragmen(
                        carName,
                        carPrice
                    )
                )

            }
        })
        adapter.submitData(data)
        binding?.rvcar?.layoutManager=LinearLayoutManager(context)
        binding?.rvcar?.adapter = adapter
    }

}