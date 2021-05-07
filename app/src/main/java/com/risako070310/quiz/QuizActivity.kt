package com.risako070310.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    val quizList: List<List<String>> = listOf(
        listOf("Androidアプリコースのキャラクターの名前は？", "ランディ", "フィル", "ドロイド", "ランディ"),
        listOf("Androidを開発する言語はどれ？", "JavaScript", "Kotlin", "Swift", "Kotlin"),
        listOf("ImageViewは何を扱える要素？", "文字", "音声", "画像", "画像")
    )

    val shuffledLists: List<List<String>> = quizList.shuffled()

    var quizCount: Int = 0

    var correctAnswer: String = ""

    var correctCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        showQuestion()

        answerButton1.setOnClickListener {
            checkAnswer(answerButton1.text.toString())
        }
        answerButton2.setOnClickListener {
            checkAnswer(answerButton2.text.toString())
        }
        answerButton3.setOnClickListener {
            checkAnswer(answerButton3.text.toString())
        }

        nextButton.setOnClickListener {
            if(quizCount == quizList.size) {
                val resultIntent = Intent(this, ResultActivity::class.java)
                resultIntent.putExtra("quizCount", quizList.size)
                resultIntent.putExtra("correctCount", correctCount)

                startActivity(resultIntent)
                finish()
            } else {
                judgeImage.isVisible = false

                answerButton1.isEnabled = true
                answerButton2.isEnabled = true
                answerButton3.isEnabled = true

                correctAnswerText.text = ""

                showQuestion()

                nextButton.isVisible = false
            }
        }

    }

    fun showQuestion(){
        val question: List<String> = shuffledLists[quizCount]
        quizText.text = question[0]
        answerButton1.text = question[1]
        answerButton2.text = question[2]
        answerButton3.text = question[3]

        correctAnswer = question[4]
    }

    fun checkAnswer(answerText: String){
        if(answerText == correctAnswer){
            judgeImage.setImageResource(R.drawable.maru_image)
            correctCount++
        } else {
            judgeImage.setImageResource(R.drawable.batu_image)
        }
        showAnswer()
        quizCount++
    }

    fun showAnswer(){
        correctAnswerText.text = "正解: $correctAnswer"
        judgeImage.isVisible = true
        nextButton.isVisible = true

        answerButton1.isEnabled = false
        answerButton2.isEnabled = false
        answerButton3.isEnabled = false
    }
}