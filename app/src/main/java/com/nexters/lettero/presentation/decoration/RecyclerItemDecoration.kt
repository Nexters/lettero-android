package com.nexters.lettero.presentation.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nexters.lettero.ext.dpToPx

class RecyclerItemDecoration(private val vertical: Int = 0, private val horizontal: Int = 0) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        parent.context.run {
            outRect.bottom = vertical.dpToPx(this)
            outRect.top = vertical.dpToPx(this)
            outRect.right = horizontal.dpToPx(this)
            outRect.left = horizontal.dpToPx(this)
        }
    }
}
