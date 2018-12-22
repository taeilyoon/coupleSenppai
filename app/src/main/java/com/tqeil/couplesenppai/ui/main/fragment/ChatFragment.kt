package com.tqeil.couplesenppai.ui.main.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.tqeil.couplesenppai.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.tqeil.couplesenppai.Model.ChatModel
import com.tqeil.couplesenppai.databinding.FragmentChatBinding
import kotlinx.android.synthetic.main.fragment_chat.view.*
import net.jspiner.ask.ui.base.BaseFragment
import net.jspiner.ask.ui.base.BaseViewModel
import com.google.firebase.database.ChildEventListener
import kotlinx.android.synthetic.main.fragment_chat.*
import android.databinding.adapters.TextViewBindingAdapter.setText
import android.databinding.adapters.NumberPickerBindingAdapter.setValue
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*



class ChatFragment: BaseFragment<FragmentChatBinding, BaseViewModel>() {

    override fun getLayoutId() = R.layout.fragment_chat

    companion object {
        var data : MutableList<ChatModel> = mutableListOf()

        fun create(): ChatFragment {
            val fragment = ChatFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }

    }

    var adapter = ChatAdapter(data)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view.recyclerView.adapter = adapter
        var lm =  LinearLayoutManager(activity)
        view.recyclerView.layoutManager = lm
        val database = FirebaseDatabase.getInstance()
        val myRef = database.reference

        myRef.child("message")
            .addChildEventListener(object : ChildEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    Log.d("Sever Error", p0.toString())

                }

                override fun onChildMoved(p0: DataSnapshot, p1: String?) {
                    assert(true)
                }

                override fun onChildChanged(p0: DataSnapshot, p1: String?) {
                }

                override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                    val chatData = p0.getValue<ChatModel>(ChatModel::class.java)  // chatData를 가져오고
                    data.add(chatData!!)
                    adapter.notifyDataSetChanged()
                }

                override fun onChildRemoved(p0: DataSnapshot) {
                    assert(true)
                }

            })


        send.setOnClickListener {


            val now = System.currentTimeMillis()
            val date = Date(now)
            val sdf = SimpleDateFormat("yyyy-MM-dd")

            val getTime = sdf.format(date)



            val chatData = ChatModel().setContent(send_message.text.toString())
                .setSender("User")
                .settime(getTime)
            // 유저 이름과 메세지로 chatData 만들기
           myRef.child("message").push()
                .setValue(chatData)  // 기본 database 하위 message라는 child에 chatData를 list로 만들기
            send_message.setText("")

        }

        plus.setOnClickListener {
            //TODO:: POPUP
        }
    }


    inner class ChatAdapter(var data : MutableList<ChatModel>) : RecyclerView.Adapter<VH>() {
        override fun onBindViewHolder(holder: VH, position: Int) {


            holder.content.text = data[position].content
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val inflater = LayoutInflater.from(parent.context)

            val v = inflater.inflate(R.layout.card_chat, parent, false)

            return VH(v)
        }

        override fun getItemCount(): Int {
            return data.size
        }



    }
    inner class VH(view: View) : RecyclerView.ViewHolder(view){
        lateinit var content: TextView
        lateinit var time: TextView
        lateinit var sender: TextView
        lateinit var textView4: TextView
        lateinit var Profile: ImageView

        init {
            content = view.findViewById(R.id.content_text)
        }

    }
}