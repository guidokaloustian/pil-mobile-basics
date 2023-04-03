package com.example.pmb.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pmb.mvp.model.CounterModel
import com.example.pmb.mvp.presenter.CounterPresenter
import com.example.pmb.mvp.view.CounterView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CounterPresenter(CounterView(this), CounterModel())
    }
}
