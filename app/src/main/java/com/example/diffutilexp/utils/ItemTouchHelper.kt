package com.example.diffutilexp.utils

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilexp.adapters.ProductAdapter
import com.example.diffutilexp.models.Product

class ItemTouchHelperFAdapt(
    val adapter: ProductAdapter,
    val swipeListener: (Product) -> Unit
) :
    ItemTouchHelper.Callback() {

    var bgRect = RectF()
    var bgPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    var itemBounds = RectF()

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return if (viewHolder is ProductAdapter.ProductAdapterViewHolder) {
            makeFlag(ItemTouchHelper.ACTION_STATE_SWIPE, ItemTouchHelper.START)
        } else {
            makeFlag(ItemTouchHelper.ACTION_STATE_IDLE, ItemTouchHelper.START)
        }
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }


    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        swipeListener.invoke(adapter.items[viewHolder.adapterPosition])
    }


    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        val itemView = viewHolder.itemView

        // drawIcon(c, itemView, dX)
        drawBackground(c, itemView, dY)
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }


    private fun drawBackground(canvas: Canvas, itemView: View, dx: Float) {

        with(bgPaint){
            color = Color.RED
        }

        with(bgRect){
            left = itemView .right .toFloat()
            top = itemView.top.toFloat()
            right = dx
            bottom = itemView .bottom .toFloat()
        }

     canvas.drawRect(bgRect, bgPaint)
    }

    private fun drawIcon(canvas: Canvas, itemView: View, dx: Float) {

    }
}