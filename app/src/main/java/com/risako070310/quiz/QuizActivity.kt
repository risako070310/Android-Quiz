package com.risako070310.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val quizIntent: Intent = Intent(this, QuizActivity::class.java)

        startButton.setOnClickListener {
            startActivity(quizIntent)
        }
    }
}