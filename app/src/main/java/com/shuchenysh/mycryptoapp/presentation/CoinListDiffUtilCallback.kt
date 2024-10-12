package com.shuchenysh.mycryptoapp.presentation

import androidx.recyclerview.widget.DiffUtil
import com.shuchenysh.mycryptoapp.domain.CoinInfo

object CoinListDiffUtilCallback : DiffUtil.ItemCallback<CoinInfo>() {

    override fun areItemsTheSame(oldItem: CoinInfo, newItem: CoinInfo) =
        oldItem.fromSymbol == newItem.fromSymbol

    override fun areContentsTheSame(oldItem: CoinInfo, newItem: CoinInfo) = oldItem == newItem
}