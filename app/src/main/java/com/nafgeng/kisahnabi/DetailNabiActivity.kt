package com.nafgeng.kisahnabi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.nafgeng.kisahnabi.databinding.ActivityDetailNabiBinding
import com.nafgeng.kisahnabi.network.ResponseNabiItem

class DetailNabiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailNabiBinding

    companion object{
        const val DETAIL_DATA = "A"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNabiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<ResponseNabiItem>(DETAIL_DATA)

        binding.txtDetailnamanabi.text = data?.nama
        binding.txtDetailumurnabi.text = data?.usia
        binding.txtTplahirdetailnabi.text = data?.tpKelahiran
        binding.txtDetaildeskripsinabi.text = data?.deskripsi
        binding.imgDetailavatarnabi.load(data?.avatar)
    }
}