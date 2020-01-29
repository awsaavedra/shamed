package com.example.shamed.ui.main

import android.content.Context
import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView

/**
 * A [RecyclerView decorator][RecyclerView.ItemDecoration] which, if applied over a recycler view
 * with a [PagerSnapHelper][android.support.v7.widget.PagerSnapHelper] set up (i.e. that behaves like
 * a full-screen [ViewPager][android.support.v4.view.ViewPager]), allows for easily setting up gaps
 * between the RV's items as typically done in a cards carousel, all-the-while keeping the items
 * properly snapped to the screen's center.
 *
 * **Typical usage:**
 *
 * ```
 * // Get each item to take exactly 80% of the screen's width.
 * // In addition, enable a sneak-preview of neighbouring (unsnapped) items of 1% of their width.
 * val cardWidthPixels = activity.resources.displayMetrics.widthPixels * 0.80f
 * recyclerView.addItemDecoration(RVPagerSnapFancyDecorator(activity, cardWidthPixels, 0.01f))
 * ```
 */
open class RVPagerSnapFancyDecorator : RecyclerView.ItemDecoration {
    private val mInterItemsGap: Int
    private val mNetOneSidedGap: Int

    constructor(context: Context, itemWidth: Int, itemPeekingPercent: Float = .035f)
            : this(context.resources.displayMetrics.widthPixels, itemWidth, itemPeekingPercent)

    constructor(totalWidth: Int, itemWidth: Int, itemPeekingPercent: Float = .035f) {
        val cardPeekingWidth = (itemWidth * itemPeekingPercent + .5f).toInt()

        mInterItemsGap = (totalWidth - itemWidth) / 2
        mNetOneSidedGap = mInterItemsGap / 2 - cardPeekingWidth
    }

    @Deprecated("")
    override fun getItemOffsets(
        outRect: Rect, itemPosition: Int,
        parent: RecyclerView
    ) {
        // second parent needs to be a separate view
        val index = parent.getChildAdapterPosition(parent)
        val isFirstItem = isFirstItem(index)
        val isLastItem = isLastItem(index, parent)

        val leftInset = if (isFirstItem) mInterItemsGap else mNetOneSidedGap
        val rightInset = if (isLastItem) mInterItemsGap else mNetOneSidedGap

        outRect.set(leftInset, 0, rightInset, 0)
    }


    private fun isFirstItem(index: Int) = index == 0

    private fun isLastItem(index: Int, recyclerView: RecyclerView): Boolean {
        recyclerView.adapter?.apply {
            return index == this.itemCount - 1
        }
        return false
    }
}