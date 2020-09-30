package sim.coder.androidchallengeno5ch3.Model

import androidx.annotation.StringRes

data class Question (
    @StringRes val textResId: Int,
    val answer: Boolean,
    var answered : Boolean
)
