package net.alexandroid.utils.recyclerviewtests

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.activity_main.*
import net.alexandroid.utils.mylog.MyLog

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var customLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MyLog.init(this, "ZAQ", true)
        MyLog.e("=============== ON CREATE ===============")

        customLayoutManager = CustomLayoutManager(this)

        viewAdapter = MyAdapter(getMyDataSet()).apply {
            // TODO https://medium.com/@hanru.yeh/recyclerviews-views-are-blinking-when-notifydatasetchanged-c7b76d5149a2
            //setHasStableIds(true)
        }

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout customLayoutManager
            layoutManager = customLayoutManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter
        }

        swipeRefresh.setOnRefreshListener(this)
    }

    //SwipeRefreshLayout.OnRefreshListener
    override fun onRefresh() {
        swipeRefresh.postDelayed({ swipeRefresh.isRefreshing = false }, 1000)
    }

    private fun getMyDataSet(): ArrayList<String> {
        val list = arrayListOf<String>()
        for (x in 0..100) {
            list.add("$x")
        }
        return list
    }
}
