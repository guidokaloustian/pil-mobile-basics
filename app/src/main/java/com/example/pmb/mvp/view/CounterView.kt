package com.example.pmb.mvp.view

import android.app.Activity
import com.example.pmb.databinding.ActivityMainBinding
import com.example.pmb.mvp.contract.CounterContract
import com.example.pmb.mvp.view.base.ActivityView

class CounterView(activity: Activity) : ActivityView(activity), CounterContract.View {

    private var binding: ActivityMainBinding = ActivityMainBinding.inflate(activity.layoutInflater)

    init {
        activity.setContentView(binding.root)
    }

    override fun setCounter(counter: String) {
        binding.counter.text = counter
    }

    override fun getCounter(): String = binding.counterHint.text.toString()

    override fun btnPressIncrement(onClick: () -> Unit) {
        binding.addButton.setOnClickListener { onClick() }
    }

    override fun btnPressDecrement(onClick: () -> Unit) {
        binding.substractButton.setOnClickListener { onClick() }
    }

    override fun btnPressReset(onClick: () -> Unit) {
        binding.resetButton.setOnClickListener { onClick() }
    }
}
