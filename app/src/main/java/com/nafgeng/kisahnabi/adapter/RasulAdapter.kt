package com.nafgeng.kisahnabi.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.nafgeng.kisahnabi.DetailRasulActivity
import com.nafgeng.kisahnabi.databinding.FragmentRasulBinding
import com.nafgeng.kisahnabi.databinding.ItemRecyclerNabiBinding
import com.nafgeng.kisahnabi.databinding.ItemRecyclerRasulBinding
import com.nafgeng.kisahnabi.network.ResponseNabiItem

class RasulAdapter(private val listDataRasul : ArrayList<ResponseNabiItem> = arrayListOf()) :
    RecyclerView.Adapter<RasulAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun addDataRasul(getData: List<ResponseNabiItem>) {
        listDataRasul.clear()
        listDataRasul.addAll(getData)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemRecyclerRasulBinding)  : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val listitemrasulbinding = ItemRecyclerRasulBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(listitemrasulbinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listDataRasul[position]

        holder.binding.txtNamarasul.text = data.nama
        holder.binding.imgRasul.load(data.avatar) {
            scale(Scale.FILL)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context,DetailRasulActivity::class.java)
            intent.putExtra(DetailRasulActivity.DETAIL_DATA,data)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listDataRasul.size
}