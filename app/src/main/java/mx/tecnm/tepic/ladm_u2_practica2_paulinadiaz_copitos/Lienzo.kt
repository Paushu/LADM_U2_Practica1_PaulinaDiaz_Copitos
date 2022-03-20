package mx.tecnm.tepic.ladm_u2_practica2_paulinadiaz_copitos

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.MotionEvent
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class Lienzo (ce:MainActivity) : View(ce) {
    var ce = ce
    val circles = Array<Circle>(200, { Circle(this) })


    val corutina = GlobalScope.launch {
        while (true) {
            ce.runOnUiThread {
                invalidate()
            }
            delay(20L)
        }
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()


        //Cielo
        c.drawColor(Color.rgb(149,164,246))


        ce.setTitle("ancho ${width}  alto ${height}")

        //Tierra
        p.color = Color.rgb(214,214,214)
        c.drawRect(1f, 500f, 1080f, 1500f, p)
        //Hielo
        p.color = Color.rgb(119,211,202)
        c.drawRect(1f, 1200f, 1080f, 1500f, p)


        //Tronco
        p.color = Color.rgb(185,136,120)
        c.drawRect(1F,800F,100F,1200F,p)
        //Una casa fea porque no la hizo un arqui

        p.color = Color.WHITE
        c.drawRect(300f,495F,700F,900F,p)
        p.color = Color.RED
        c.drawRect(300f,500F,700F,900F,p)
        p.color = Color.BLACK
        c.drawCircle(400f,600f,60f,p)
        //Jardinera con nieve
        p.color = Color.WHITE
        c.drawRect(500f,795F,900F,900F,p)
        p.color = Color.BLACK
        c.drawRect(500f,800F,900F,900F,p)


        //Arbolito nevado
        p.color = Color.rgb(255,255,255)
        c.drawCircle(55F,830F,155F,p)
        p.color = Color.rgb(103,166,106)
        c.drawCircle(50F,850F,150F,p)
        //Luna
        p.color = Color.WHITE
        c.drawCircle(150f,200f,80f,p)


        for (circ in circles) {
            circ.mover()
            circ.pintar(c)
        }
        /*(0..circles.size-1).forEach{
            circles[it].mover()
            circles[it].pintar(c)
        }*/


    }
}

