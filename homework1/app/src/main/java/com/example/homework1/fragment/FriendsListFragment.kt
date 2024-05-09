package com.example.homework1.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.example.homework1.R

class FriendsListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var lottieAnimation: LottieAnimationView

    // 模拟好友数据
    private val friends = listOf(
        "Alice",
        "Bob",
        "Charlie",
        "David",
        "Eve"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_friends_list, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        lottieAnimation = view.findViewById(R.id.lottieAnimation)

        setupRecyclerView()
        simulateDataLoading()

        return view
    }

    private fun setupRecyclerView() {
        recyclerView.adapter = SimpleAdapter(friends)
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun simulateDataLoading() {
        // 延迟5秒来模拟数据加载
        lottieAnimation.postDelayed({
            lottieAnimation.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }, 5000)  // 延迟5秒
    }
}

class SimpleAdapter(private val data: List<String>) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // 使用Android内置的简单列表项布局
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = data[position]
    }

    override fun getItemCount() = data.size
}

