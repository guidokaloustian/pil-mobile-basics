package com.example.pmb

import com.example.pmb.mvp.contract.CounterContract
import com.example.pmb.mvp.model.CounterModel
import com.example.pmb.mvp.presenter.CounterPresenter
import com.example.pmb.util.Constants.THREE
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CounterPresenterTest {

    private lateinit var counterPresenter: CounterContract.Presenter

    private lateinit var counterModel: CounterContract.Model

    @MockK
    private lateinit var counterView: CounterContract.View

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        counterModel = CounterModel()
        counterPresenter = CounterPresenter(counterView, counterModel)

        verify { counterView.btnPressIncrement(any()) }
        verify { counterView.btnPressDecrement(any()) }
        verify { counterView.btnPressReset(any()) }


    }

    @Test
    fun `the counter increases when the increment button is pressed`() {
        val number = THREE.toString()

        counterPresenter.btnIncrement(number)

        verify { counterView.setCounter(counterModel.getCounter()) }
        Assert.assertEquals(number, counterModel.getCounter())
    }

    @Test
    fun `the counter decreases when the decrement button is pressed`() {
        val number = THREE.toString()
        counterPresenter.btnDecrement(number)

        verify { counterView.setCounter(counterModel.getCounter()) }
        Assert.assertEquals((number.toInt() * -1), counterModel.getCounter().toInt())
    }

    @Test
    fun `the counter is zero when the reset button is pressed`() {
        val number = THREE.toString()
        counterPresenter.btnIncrement(number)
        counterPresenter.btnReset()

        verify { counterView.setCounter(counterModel.getCounter()) }
        Assert.assertEquals(0, counterModel.getCounter().toInt())
    }
}
