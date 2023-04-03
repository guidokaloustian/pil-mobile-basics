package com.example.pmb.mvp.model

import com.example.pmb.mvp.contract.CounterContract
import com.example.pmb.util.Constants.ZERO

class CounterModel : CounterContract.Model {
    private var counter = ZERO

    override fun getCounter(): String = counter.toString()

    override fun inc(number: Int) {
        counter += number
    }

    override fun dec(number: Int) {
        counter -= number
    }

    override fun reset() {
        counter = ZERO
    }
}
