package sim.coder.androidchallengeno5ch3.Model

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import sim.coder.androidchallengeno5ch3.R
import kotlin.contracts.contract

class QuizViewModel :ViewModel (){


    private val questionBank = listOf(

        Question(R.string.eFirst,true,false),
        Question(R.string.eSecound,true,false),
        Question(R.string.eThird,false,false),
        Question(R.string.eFour,true,false),
        Question(R.string.eFive,true,false),
        Question(R.string.eSix,true,false)
    )

    var currentIndex = 0
    val currentQuestionAnswer:Boolean
    get() = questionBank[currentIndex].answer

    val currentQuestionText:Int
    get() = questionBank[currentIndex].textResId

    val nextQuestion:Boolean
    get() = questionBank[currentIndex +1].answered

    val prevQuestion:Boolean
    get() = questionBank[currentIndex -1].answered


    fun moveToNext (){
       currentIndex = (currentIndex + 1) % questionBank.size


    }

    fun moveToPrev(){
        currentIndex = (currentIndex -1) % questionBank.size
    }

    fun isAnswered(state:Boolean){
        questionBank[currentIndex].answered=state
    }

}
