package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.wordle.R

class MainActivity : AppCompatActivity() {

    private lateinit var wordToGuess: String
    private var tries = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordToGuess = FourLetterWordList.getRandomFourLetterWord()

        val guessView1 = findViewById<TextView>(R.id.GuessView1)
        val guessAns1 = findViewById<TextView>(R.id.GuessAns1)
        val guessCheck1 = findViewById<TextView>(R.id.GuessCheck1)
        val guessCheckAns1 = findViewById<TextView>(R.id.GuessCheckAns1)

        val guessView2 = findViewById<TextView>(R.id.GuessView2)
        val guessAns2 = findViewById<TextView>(R.id.GuessAns2)
        val guessCheck2 = findViewById<TextView>(R.id.GuessCheck2)
        val guessCheckAns2 = findViewById<TextView>(R.id.GuessCheckAns2)
        val guessView3 = findViewById<TextView>(R.id.GuessView3)
        val guessAns3 = findViewById<TextView>(R.id.GuessAns3)
        val guessCheck3 = findViewById<TextView>(R.id.GuessCheck3)
        val guessCheckAns3 = findViewById<TextView>(R.id.GuessCheckAns3)
        val answer = findViewById<TextView>(R.id.answer)

        val userInput = findViewById<EditText>(R.id.et_Simple)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val input = userInput.text.toString().uppercase()
            val checking = checkGuess(input)

            if(tries == 1){

                guessAns1.text = input
                guessCheckAns1.text = checking
                guessView1.visibility = View.VISIBLE
                guessAns1.visibility = View.VISIBLE
                guessCheck1.visibility = View.VISIBLE
                guessCheckAns1.visibility = View.VISIBLE
                tries++
            }else if(tries == 2){
                guessAns2.text = input
                guessCheckAns2.text = checking.toString()
                guessView2.visibility = View.VISIBLE
                guessAns2.visibility = View.VISIBLE
                guessCheck2.visibility = View.VISIBLE
                guessCheckAns2.visibility = View.VISIBLE
                tries++
            }else if(tries == 3){
                guessAns3.text = input
                guessCheckAns3.text = checking.toString()
                guessView3.visibility = View.VISIBLE
                guessAns3.visibility = View.VISIBLE
                guessCheck3.visibility = View.VISIBLE
                guessCheckAns3.visibility = View.VISIBLE
                tries++
                button.text = "RESET"
                answer.text = wordToGuess
            }else{
                tries = 1
                answer.text = ""
                wordToGuess = FourLetterWordList.getRandomFourLetterWord()
                guessView3.visibility = View.INVISIBLE
                guessAns3.visibility = View.INVISIBLE
                guessCheck3.visibility = View.INVISIBLE
                guessCheckAns3.visibility = View.INVISIBLE
                guessView2.visibility = View.INVISIBLE
                guessAns2.visibility = View.INVISIBLE
                guessCheck2.visibility = View.INVISIBLE
                guessCheckAns2.visibility = View.INVISIBLE
                guessView1.visibility = View.INVISIBLE
                guessAns1.visibility = View.INVISIBLE
                guessCheck1.visibility = View.INVISIBLE
                guessCheckAns1.visibility = View.INVISIBLE
                button.text = "Guess"
            }
            ///userInput.setText("")
        }


    }


    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}