package com.nexters.lettero.presentation.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.nexters.lettero.R

class RetroAppBar(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {
    init {
        context.run {
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            inflater.inflate(R.layout.layout_retro_arr_bar, this@RetroAppBar, false).apply {
                addView(this)
            }
        }
    }
}
