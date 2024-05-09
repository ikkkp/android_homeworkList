package com.example.homework2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.Calendar

class ClockView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    private val paint = Paint().apply {
        isAntiAlias = true
    }
    private var hour = 0
    private var minute = 0
    private var second = 0

    private fun updateHands() {
        val calendar = Calendar.getInstance()
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
        second = calendar.get(Calendar.SECOND)
        invalidate()
    }

    init {
        Thread {
            while (true) {
                updateHands()
                Thread.sleep(1000)
            }
        }.start()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = Math.min(centerX, centerY) - 50

        // Draw the clock face
        paint.color = Color.LTGRAY
        paint.style = Paint.Style.FILL
        canvas.drawCircle(centerX, centerY, radius, paint)

        // Draw hour hand
        paint.color = Color.BLACK
        canvas.drawLine(centerX, centerY,
            centerX + radius * 0.5f * Math.cos(Math.toRadians((hour + minute / 60.0) * 30 - 90)).toFloat(),
            centerY + radius * 0.5f * Math.sin(Math.toRadians((hour + minute / 60.0) * 30 - 90)).toFloat(),
            paint)

        // Draw minute hand
        paint.color = Color.BLUE
        canvas.drawLine(centerX, centerY,
            centerX + radius * 0.8f * Math.cos(Math.toRadians((minute + second / 60.0) * 6 - 90)).toFloat(),
            centerY + radius * 0.8f * Math.sin(Math.toRadians((minute + second / 60.0) * 6 - 90)).toFloat(),
            paint)

        // Draw second hand
        paint.color = Color.RED
        canvas.drawLine(centerX, centerY,
            centerX + radius * 0.9f * Math.cos(Math.toRadians((second * 6 - 90).toDouble())).toFloat(),
            centerY + radius * 0.9f * Math.sin(Math.toRadians((second * 6 - 90).toDouble())).toFloat(),
            paint)
    }
}
