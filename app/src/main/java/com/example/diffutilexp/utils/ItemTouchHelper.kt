package com.example.diffutilexp.utils

import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilexp.adapters.ProductAdapter
import com.example.diffutilexp.models.Product
import android.R.attr.bottom
import android.R.attr.right
import android.R.attr.top
import android.R.attr.left
import android.R
import android.graphics.*
import android.graphics.drawable.Drawable



class ItemTouchHelperFAdapt(
    val adapter: ProductAdapter,
    val swipeListener: (Product) -> Unit
) :
    ItemTouchHelper.Callback() {

    var bgRect = RectF()
    var bgPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    var paintBlue = Paint()

    var iconBounds = Rect()

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
       // drawIcon(c, itemView, dY)
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
        val icon = itemView.resources.getDrawable(R.drawable.ic_btn_speak_now)
        val iconSize = itemView.resources.getDimensionPixelSize(R.dimen.app_icon_size)
        val space = itemView.resources.getDimensionPixelSize(R.dimen.app_icon_size)
        val margin = (itemView.bottom - itemView.top-iconSize)/2

        with(bgRect){
            left=itemView.right + dx + space
            top = itemView .top + margin .toFloat()
            right = itemView.right+dx.toInt() + iconSize + space .toFloat()
            bottom = itemView.bottom - margin .toFloat()
        }

        icon .bounds = iconBounds
        icon .draw(canvas)

     /* val bitmap = BitmapFactory.decodeResource(itemView.resources, R.drawable.ic_btn_speak_now)
        val rect1 = Rect()
        val rect2 = Rect()

        paintBlue.color = Color.BLUE

        canvas.drawBitmap(bitmap,rect1,rect2,paintBlue) */
    }
}