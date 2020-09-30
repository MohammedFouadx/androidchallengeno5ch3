package sim.coder.androidchallengeno5ch3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
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
            //quizViewModel.moveToPrev()
            if (quizViewModel.prevQuestion==true){
                trueButton.isEnabled=false
                falseButton.isEnabled=false
                quizViewModel.moveToPrev()
            }else{
                quizViewModel.moveToPrev()
                updateQuestion()
            }


        }

        nextButton.setOnClickListener {
            //quizViewModel.moveToNext()
            if (quizViewModel.nextQuestion==true) {
                trueButton.isEnabled = false
                falseButton.isEnabled = false
                quizViewModel.moveToNext()
            }else{
                quizViewModel.moveToNext()
                updateQuestion()
            }


        }



        trueButton.setOnClickListener {
            checkAnswer(true)
            quizViewModel.isAnswered(true)


        }

        falseButton.setOnClickListener {
            checkAnswer(false )
            quizViewModel.isAnswered(true)
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



        } else {

            Toast.makeText(this, "OOps! false", Toast.LENGTH_SHORT).show()
        }

    }







    }









