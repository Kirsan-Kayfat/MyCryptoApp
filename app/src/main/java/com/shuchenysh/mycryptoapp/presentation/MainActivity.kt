package com.shuchenysh.mycryptoapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shuchenysh.mycryptoapp.databinding.ActivityMainBinding
import com.shuchenysh.mycryptoapp.domain.CoinInfo
import com.shuchenysh.mycryptoapp.presentation.adapters.CoinInfoAdapter

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinInfo) {
                val intent = CoinDetailActivity.newIntent(
                    this@MainActivity,
                    coinPriceInfo.fromSymbol
                )
                startActivity(intent)
            }
        }
        binding.rvCoinPriceList?.adapter = adapter
        binding.rvCoinPriceList?.itemAnimator = null
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.coinInfoList.observe(this) { adapter.submitList(it) }
    }
}