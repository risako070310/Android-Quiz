package com.risako070310.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        
        val quizCount = intent.getIntExtra("quizCount", 0)
        quizCountText.text = "$quizCount 問中..."

        val correctCount = intent.getIntExtra("correctCount", 0)
        correctCountText.text = correctCount.toString()

        againButton.setOnClickListener {
            val quizIntent = Intent(this, QuizActivity::class.java)
            startActivity(quizIntent)
            finish()
        }

    }
}