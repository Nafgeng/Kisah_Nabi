package com.nafgeng.kisahnabi.adapter


import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.nafgeng.kisahnabi.DetailNabiActivity
import com.nafgeng.kisahnabi.databinding.ItemRecyclerNabiBinding
import com.nafgeng.kisahnabi.network.ResponseNabiItem

class NabiAdapter(private val listDataNabi : ArrayList<ResponseNabiItem> = arrayListOf()) :
    RecyclerView.Adapter<NabiAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun addDataNabi(getData: List<ResponseNabiItem>) {
        listDataNabi.clear()
        listDataNabi.addAll(getData)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemRecyclerNabiBinding)  : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val listitemnabibinding = ItemRecyclerNabiBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(listitemnabibinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listDataNabi[position]

        holder.binding.txtNamanabi.text = data.nama
        holder.binding.imgNabi.load(data.avatar) {
            scale(Scale.FILL)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailNabiActivity::class.java)
            intent.putExtra(DetailNabiActivity.DETAIL_DATA, data)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listDataNabi.size
}