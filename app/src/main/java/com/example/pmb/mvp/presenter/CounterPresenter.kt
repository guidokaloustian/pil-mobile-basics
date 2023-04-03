package com.example.pmb.mvp.presenter

import com.example.pmb.mvp.contract.CounterContract

class CounterPresenter(private val view: CounterContract.View, private val model: CounterContract.Model) : CounterContract.Presenter {

    init {
        view.btnPressIncrement { btnIncrement(view.getCounter()) }
        view.btnPressDecrement { btnDecrement(view.getCounter()) }
        view.btnPressReset { btnReset() }
    }

    override fun btnIncrement(number: String) {
        model.inc(number.toInt())
        view.setCounter(model.getCounter())
    }

    override fun btnDecrement(number: String) {
        model.dec(number.toInt())
        view.setCounter(model.getCounter())
    }

    override fun btnReset() {
        model.reset()
        view.setCounter(model.getCounter())
    }


}
