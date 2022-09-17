package com.example.wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity()  {
    var wordToGuess = FourLetterWordList.getRandomFourLetterWord()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val guessing = findViewById<Button>(R.id.Submit)
        guessing.setOnClickListener {
            Toast.makeText(it.context, "Only 3 attempts allowed. Guess the word in 3 attempts !!", Toast.LENGTH_LONG).show()
        }

        val inputted = findViewById<View>(R.id.UserInput)
        var guesswork = inputted.toString()
        if (guesswork == wordToGuess){
            println("Correct Guess")
        }
        else {
            checkGuess(wordToGuess)
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
