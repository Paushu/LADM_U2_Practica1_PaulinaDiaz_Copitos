package mx.tecnm.tepic.ladm_u2_practica2_paulinadiaz_copitos

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Circle(l:Lienzo){
    var x = 0f
    var y = 0f

    var movY = 0f
    var color = Color.WHITE

    init {
        x = rand(2000)
        y = rand(1540)
        movY = rand(6)+2
        color = Color.WHITE
    }

    private fun rand(hasta:Int) : Float{
        return Random.nextInt(hasta).toFloat()
    }

    fun mover(){
        y += movY
        if(y <0 || y>1540){
            y=1540-y
        }
    }

    fun pintar(canvas: Canvas){
        var p = Paint()
        p.color = color
        canvas.drawCircle(x,y,5f,p)
    }

}