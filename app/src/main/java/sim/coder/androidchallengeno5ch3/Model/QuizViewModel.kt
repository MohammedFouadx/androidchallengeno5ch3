package sim.coder.androidchallengeno5ch3.Model

import androidx.lifecycle.ViewModel
import sim.coder.androidchallengeno5ch3.R
class QuizViewModel :ViewModel (){
    var currentIndex = 0
    private val questionBank = listOf(
        Question(R.string.eFirst,true,""),
        Question(R.string.eSecound,true,""),
        Question(R.string.eThird,false,""),
        Question(R.string.eFour,true,""),
        Question(R.string.eFive,true,""),
        Question(R.string.eSix,true,"")
    )

    val currentQuestionAnswer:Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText:Int
        get() = questionBank[currentIndex].textResId
    val nextQuestion:String
        get() = questionBank[currentIndex +1].answered
    val prevQuestion:String
        get() = questionBank[currentIndex -1].answered

    fun moveToNext (){
        currentIndex = (currentIndex + 1) % questionBank.size

    }
    fun moveToPrev(){
        currentIndex = (currentIndex -1) % questionBank.size
    }
    fun isAnswered(state:String){
        questionBank[currentIndex].answered=state
    }
}