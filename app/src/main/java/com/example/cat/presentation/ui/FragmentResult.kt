package com.example.cat.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cat.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import kotlinx.coroutines.async
import kotlinx.coroutines.joinAll


class FragmentResult : Fragment() {

    lateinit var recyclerResult:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db: AppDatabase? = App.instance?.database
        val userDao: UserDao = db?.userDao()!!
        var resultlist: MutableList<GameResult> = mutableListOf()

        recyclerResult = view.findViewById(R.id.recyclerresult)
        recyclerResult.layoutManager = LinearLayoutManager(this.context)

        GlobalScope.launch {
            val list: List<User> = userDao.getAll() as kotlin.collections.List<com.example.cat.User>
            for (result in list) {
                if (nowName.Name == result.name) {
                    resultlist.add(GameResult(result.date, result.score))
                }
            }
        }
        Thread.sleep(2000)
        recyclerResult.adapter = ItemAdapter(this.requireContext(), resultlist)
    }
}