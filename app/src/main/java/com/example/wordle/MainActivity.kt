package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity()  {
    private val wordToGuess = FourLetterWordList.getRandomFourLetterWord()
    var guessCounter = 0
    var userCurrentGuess = ""

    private fun checkGuess(guess: String) : String {
        var guess = wordToGuess.uppercase()
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guess1 = findViewById<TextView>(R.id.guess1)
        val guess1Check = findViewById<TextView>(R.id.guess1check)
        val enteredguess1 = findViewById<TextView>(R.id.word1)
        val enteredguess1check = findViewById<TextView>(R.id.word1check)

        val guess2 = findViewById<TextView>(R.id.guess2)
        val guess2check = findViewById<TextView>(R.id.guess2check)
        val enteredguess2 = findViewById<TextView>(R.id.word2)
        val enteredguess2check = findViewById<TextView>(R.id.word2check)

        val guess3 = findViewById<TextView>(R.id.guess3)
        val guess3check = findViewById<TextView>(R.id.guess3check)
        val enteredguess3 = findViewById<TextView>(R.id.word3)
        val enteredguess3check = findViewById<TextView>(R.id.word3check)

        val userinputguess = findViewById<EditText>(R.id.UserInput)
        val finalanswer = findViewById<TextView>(R.id.FinalAnswer)
        val guessButton = findViewById<Button>(R.id.SubmitButton)

        finalanswer.text = wordToGuess

        guessButton.setOnClickListener {
            guessCounter += 1
            userCurrentGuess = userinputguess.text.toString().uppercase()

            if (guessCounter == 1){
                userinputguess.text.clear()
                guess1.visibility = View.VISIBLE
                enteredguess1.text = userCurrentGuess
                enteredguess1.visibility = View.VISIBLE
                guess1Check.visibility = View.VISIBLE
                enteredguess1check.text = checkGuess(userCurrentGuess)
                enteredguess1check.visibility = View.VISIBLE
            }

            if (guessCounter == 2){
                userinputguess.text.clear()
                guess2.visibility = View.VISIBLE
                enteredguess2.text = userCurrentGuess
                enteredguess2.visibility = View.VISIBLE
                guess2check.visibility = View.VISIBLE
                enteredguess2check.text = checkGuess(userCurrentGuess)
                enteredguess2check.visibility = View.VISIBLE
            }

            if (guessCounter == 3){
                userinputguess.text.clear()
                guess3.visibility = View.VISIBLE
                enteredguess3.text = userCurrentGuess
                enteredguess3.visibility = View.VISIBLE
                guess3check.visibility = View.VISIBLE
                enteredguess3check.text = checkGuess(userCurrentGuess)
                enteredguess3check.visibility = View.VISIBLE
                guessButton.visibility = View.INVISIBLE
            }

            if (userCurrentGuess == wordToGuess ){
                finalanswer.visibility = View.VISIBLE
                guessButton.visibility = View.INVISIBLE
                userinputguess.visibility = View.INVISIBLE
            }


        }

    }
}

