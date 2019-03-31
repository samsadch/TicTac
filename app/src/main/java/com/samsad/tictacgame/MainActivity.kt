package com.samsad.tictacgame

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.Snackbar


class MainActivity : AppCompatActivity() {

    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var currentPlayer = 1
    var context = this@MainActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view:View){
        val selectedButton = view as Button
        var cellId = 0
        when(selectedButton.id){
            R.id.button->cellId=1
            R.id.button2->cellId=2
            R.id.button3->cellId=3
            R.id.button4->cellId=4
            R.id.button5->cellId=5
            R.id.button6->cellId=6
            R.id.button7->cellId=7
            R.id.button8->cellId=8
            R.id.button9->cellId=9
        }
        selectButton(cellId,selectedButton)
    }

    fun selectButton(cellId:Int,selectedButton:Button){
        selectedButton.isEnabled=false
        if(currentPlayer==1){
            currentPlayer=2
            selectedButton.text = "X"
            player1.add(cellId)
            selectedButton.setBackgroundColor(getColor(R.color.google_tic_tac_color))

        }else {
            selectedButton.text = "O"
            selectedButton.setBackgroundColor(Color.GRAY)
            player2.add(cellId)
            currentPlayer=1
        }
        checkWinner()
    }

    fun checkWinner(){
        var winner = -1
        //row1
        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            winner=1
        }
        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winner=2
        }

        //row2
        if(player1.contains(6)&&player1.contains(4)&&player1.contains(5)){
            winner=1
        }
        if(player2.contains(6)&&player2.contains(4)&&player2.contains(5)){
            winner=2
        }

        //row3
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            winner=1
        }
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winner=2
        }



        //col1
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            winner=1
        }
        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            winner=2
        }

        //col2
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            winner=1
        }
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winner=2
        }

        //col3
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            winner=1
        }
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            winner=2
        }

        //dia1
        if(player1.contains(1)&&player1.contains(5)&&player1.contains(9)){
            winner=1
        }
        if(player2.contains(1)&&player2.contains(5)&&player2.contains(9)){
            winner=2
        }


        //dia2
        if(player1.contains(3)&&player1.contains(5)&&player1.contains(7)){
            winner=1
        }
        if(player2.contains(3)&&player2.contains(5)&&player2.contains(7)){
            winner=2
        }

        if(winner!=-1){
            disableAllButtons()
            if(winner==1){
                showSnackbar("Player 1 Wins")
            }else{
              showSnackbar("Player 2 wins")
            }
        }else if(player1.size+player2.size==9){
            showSnackbar("It's a tie")
        }
    }

    fun disableAllButtons(){
        button.isEnabled=false
        button2.isEnabled=false
        button3.isEnabled=false
        button4.isEnabled=false
        button5.isEnabled=false
        button6.isEnabled=false
        button7.isEnabled=false
        button8.isEnabled=false
        button9.isEnabled=false
    }

    fun showSnackbar(user : String){
        val snackbar = Snackbar
            .make(tableLayout, user, Snackbar.LENGTH_INDEFINITE)
        snackbar.show()
    }
}
