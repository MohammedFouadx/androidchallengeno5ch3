package sim.coder.androidchallengeno5ch3


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import sim.coder.androidchallengeno5ch3.Model.QuizViewModel


class MainActivity : AppCompatActivity() {
    val quizViewModel:QuizViewModel by lazy{
        ViewModelProviders.of(this).get(QuizViewModel::class.java)
    }
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: ImageButton
    private lateinit var prevButton: ImageButton
    private lateinit var questionTextView: TextView
    var trueAnswer=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.t_button)
        falseButton = findViewById(R.id.f_button)
        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.prev_button)
        questionTextView = findViewById(R.id.q_textview)
        updateQuestion()

        prevButton.setOnClickListener {
            tv_Result.text=trueAnswer.toString()
            if (quizViewModel.currentIndex==0){
                quizViewModel.currentIndex=( quizViewModel.currentIndex + 5)
            }
            //quizViewModel.moveToPrev()
            if (quizViewModel.prevQuestion!=""){
                trueButton.isClickable=false
                falseButton.isClickable=false
                quizViewModel.moveToPrev()
            }else{
                trueButton.isClickable=true
                falseButton.isClickable=true
                quizViewModel.moveToPrev()
                updateQuestion()
            }

        }
        nextButton.setOnClickListener {
            if (quizViewModel.currentIndex==5){
                quizViewModel.currentIndex=( quizViewModel.currentIndex - 6)
            }

            //quizViewModel.moveToNext()
            if (quizViewModel.nextQuestion!="") {
                trueButton.isClickable = false
                falseButton.isClickable = false
                Log.d("aa",quizViewModel.nextQuestion)
                quizViewModel.moveToNext()
                updateQuestion()
            }else{
                trueButton.isClickable=true
                falseButton.isClickable=true
                quizViewModel.moveToNext()
                updateQuestion()
            }

        }

        trueButton.setOnClickListener {
            checkAnswer(true)
            tv_Result.text="your score is : "+trueAnswer.toString()

        }
        falseButton.setOnClickListener {
            checkAnswer(false )
            tv_Result.text="your score is : "+trueAnswer.toString()
        }

/// Challenge 1 Answer ////////////////////////////////
        questionTextView.setOnClickListener {
            updateQuestion()
        }
////////////////////////////////////////////////////
    }
    fun updateQuestion(){
        val questionTextResId= quizViewModel.currentQuestionText
        questionTextView.setText(questionTextResId)
    }
    fun checkAnswer(userAnswer:Boolean) {

        val correctAnswer = quizViewModel.currentQuestionAnswer
        if (correctAnswer == userAnswer) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            quizViewModel.isAnswered("1")
            trueButton.isClickable = false
            falseButton.isClickable = false
            trueAnswer++
        } else {
            quizViewModel.isAnswered("1")
            trueButton.isClickable = false
            falseButton.isClickable = false
            Toast.makeText(this, "OOps! false", Toast.LENGTH_SHORT).show()
        }
    }



}