package com.nafgeng.kisahnabi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.nafgeng.kisahnabi.databinding.ActivityDetailRasulBinding
import com.nafgeng.kisahnabi.network.ResponseNabiItem

class DetailRasulActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailRasulBinding

    companion object{
        const val DETAIL_DATA = "B"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRasulBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<ResponseNabiItem>(DETAIL_DATA)

        binding.txtDetailnamarasul.text = data?.nama
        binding.txtDetailumurrasul.text = data?.usia
        binding.txtDetailtplahirrasul.text = data?.tpKelahiran
        binding.txtDetaildeskripsirasul.text = data?.deskripsi
        binding.imageView.load(data?.avatar)
    }
}