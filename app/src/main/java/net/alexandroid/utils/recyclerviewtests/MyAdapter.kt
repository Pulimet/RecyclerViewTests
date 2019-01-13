package net.alexandroid.utils.recyclerviewtests

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Created on 1/13/2019 by Alexey Korolev.
 */
class MyAdapter(private val myDataset: List<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.item_my, parent, false) as TextView
        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(textView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.text = myDataset[position]
        holder.textView.setBackgroundColor(getColorByPosition(position))
    }

    private fun getColorByPosition(position: Int): Int {
        return if (position % 2 == 0) {
            Color.LTGRAY
        } else {
            Color.CYAN
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}