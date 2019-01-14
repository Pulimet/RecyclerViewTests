package net.alexandroid.utils.recyclerviewtests

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import net.alexandroid.utils.mylog.MyLog

/**
 * Created on 1/13/2019 by Alexey Korolev.
 */
class MyAdapter(private val myData: List<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView), View.OnClickListener {
        init {
            textView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                Toast.makeText(v?.context, "Position: $adapterPosition", Toast.LENGTH_SHORT).show()
            }
        }
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        // create a new view
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.item_my, parent, false) as TextView

        MyLog.i("viewType: $viewType")

        // set the view's size, margins, paddings and layout parameters
        return MyViewHolder(textView)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        MyLog.i("position: $position")
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.text = myData[position]
        holder.textView.setBackgroundColor(getColorByPosition(position))
    }

    override fun onFailedToRecycleView(holder: MyViewHolder): Boolean {
        MyLog.e("${holder.adapterPosition}")
        return super.onFailedToRecycleView(holder)
    }

    override fun onViewRecycled(holder: MyViewHolder) {
        MyLog.d("${holder.adapterPosition}")
    }

    override fun onViewAttachedToWindow(holder: MyViewHolder) {
        MyLog.w("${holder.adapterPosition}")
    }

    override fun onViewDetachedFromWindow(holder: MyViewHolder) {
        MyLog.w("${holder.adapterPosition}")
    }

    private fun getColorByPosition(position: Int): Int {
        var pos = position
        while (pos > 9) pos %= 10

        return when (pos) {
            0 -> Color.RED
            1 -> Color.parseColor("#FFA500") // orange
            2 -> Color.YELLOW
            3 -> Color.GREEN
            4 -> Color.CYAN
            5 -> Color.BLUE
            6 -> Color.parseColor("#800080") //purple
            7 -> Color.LTGRAY
            8 -> Color.DKGRAY
            9 -> Color.MAGENTA
            else -> Color.BLACK
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myData.size
}