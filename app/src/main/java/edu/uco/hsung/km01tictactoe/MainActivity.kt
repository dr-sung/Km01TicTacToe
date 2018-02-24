package edu.uco.hsung.km01tictactoe

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    private lateinit var buttons: Array<Button>
    private var turn: String = "O"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messageDisplay.text = getString(R.string.which_turn_message, turn)

        buttons = arrayOf(button0, button1, button2, button3,
                button4, button5, button6, button7, button8)

        for (b in buttons)
            b.setOnClickListener { buttonHandler(it) }

    }

    private fun buttonHandler(v: View) {
        val b = v as Button
        b.text = turn
        var color = R.color.oColor
        if (turn == "X") color = R.color.xColor
        b.setBackgroundResource(color)
        toggleTurns()
    }

    private fun toggleTurns() {
        when (turn) {
            "O" -> turn = "X"
            "X" -> turn = "O"
        }
        messageDisplay.text = getString(R.string.which_turn_message, turn)
    }
}