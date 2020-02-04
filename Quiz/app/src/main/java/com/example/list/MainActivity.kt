package com.example.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    //Create list of questions
    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true)
    )

    private var questionIndex = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Add click listener to button Next
        findViewById<Button>(R.id.next_button).setOnClickListener { nextQ() };
        findViewById<Button>(R.id.perv_button).setOnClickListener { prevQ() }
        findViewById<Button>(R.id.trueButton).setOnClickListener { answer(true) }
        findViewById<Button>(R.id.falseButton).setOnClickListener { answer(false) }
    }


    private fun nextQ() {
        //Get question index. If it is the last question it will be reseted to 0
        questionIndex = (questionIndex + 1) % 20;
        updateView();

    }

    private fun prevQ() {
        questionIndex = if (questionIndex == 0) {
            questionBank.size - 1;
        } else {
            (questionIndex - 1) % 20;
        }

      //questionIndex =  20 - abs(questionIndex - 1) % 20;

        updateView();
    }


    private fun answer(ans: Boolean) {
        if (ans == questionBank[questionIndex].answer) {
            Toast.makeText(applicationContext, "CORRECT", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(applicationContext, "WRONG", Toast.LENGTH_SHORT).show();
        }
    }

    private fun updateView() {
        //Find TextView for question and set question from QuestionBank
        //This resourceId will get text from this resource id
        findViewById<TextView>(R.id.txt_question).setText(questionBank[questionIndex].resourceId);
    }

}
