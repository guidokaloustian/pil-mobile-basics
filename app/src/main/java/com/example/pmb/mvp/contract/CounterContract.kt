package com.example.pmb.mvp.contract

interface CounterContract {

    interface View {
        fun setCounter(counter: String)
        fun getCounter(): String
        fun btnPressIncrement(onClick: () -> Unit)
        fun btnPressDecrement(onClick: () -> Unit)
        fun btnPressReset(onClick: () -> Unit)
    }

    interface Model {
        fun getCounter(): String
        fun inc(number: Int)
        fun dec(number: Int)
        fun reset()
    }

    interface Presenter {
        fun btnIncrement(number: String)
        fun btnDecrement(number: String)
        fun btnReset()
    }

}
