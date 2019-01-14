package net.alexandroid.utils.recyclerviewtests

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created on 1/14/2019 by Alexey Korolev.
 */
class CustomLayoutManager(context: Context?) : LinearLayoutManager(context) {
    var displayHeight = context?.resources?.displayMetrics?.heightPixels?:500
    override fun getExtraLayoutSpace(state: RecyclerView.State?) = displayHeight
}