package com.mytest.minipaint.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.math.pow
import kotlin.math.sqrt


class Lienzo(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var objPaint = Paint()
    var dbLinea:Boolean = false
    var dbCirculo:Boolean = false
    var dbCuadrado:Boolean = false
    var xInicial:Float = 0f
    var xFinal:Float = 0f
    var yInicial:Float = 0f
    var yFinal:Float = 0f
    var radius:Float = 0f

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            if(dbLinea == true){
                objPaint.strokeWidth = 3f
                drawLine(xInicial,yInicial,xFinal,yFinal,objPaint)
            } else if(dbCuadrado == true){
                drawRect(xInicial,yInicial,xFinal,yFinal,objPaint)
            } else if(dbCirculo == true){
                radius = sqrt((xFinal-xInicial).pow(2) +
                (yFinal - yInicial).pow(2))
                drawCircle(xInicial,yInicial,radius,objPaint)
            }

        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when {
            event?.action == MotionEvent.ACTION_DOWN -> {
                xInicial = event.x
                yInicial = event.y
            }
            event?.action == MotionEvent.ACTION_MOVE -> {
                xFinal = event.x
                yFinal = event.y
            }
        }
        invalidate()
        return true

    }


}