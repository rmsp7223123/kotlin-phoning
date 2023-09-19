package com.example.phoning.message

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivityMessageMainBinding
import com.example.phoning.dto.MessageMainDTO
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase

class MessageMainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMessageMainBinding;

    private val firebaseDatabase = FirebaseDatabase.getInstance();
    private val databaseReference = firebaseDatabase.reference;

    private lateinit var adapter: MessageMainAdapter;

    private val dateFormat = java.text.SimpleDateFormat("HH:mm", java.util.Locale.getDefault());
    private val currentTime = dateFormat.format(java.util.Date());
    private val list = ArrayList<MessageMainDTO>();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val hideActionBar = HideActionBar();
        hideActionBar.hideActionBar(this);

        adapter = MessageMainAdapter(this, list);
        binding.recv.apply {
            layoutManager = LinearLayoutManager(this@MessageMainActivity);
            this.adapter = adapter;
        };

        databaseReference.child("messages/chat").addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val name = snapshot.key;
                if (name != null) {
                    val imgRes = when (name) {
                        "해린" -> R.drawable.haerin3;
                        "혜인" -> R.drawable.hyein2;
                        "민지" -> R.drawable.minji3;
                        "다니엘" -> R.drawable.danielle5;
                        "하니" -> R.drawable.hanni11;
                        else -> R.drawable.newjeans11;
                    };
                    addList(name, imgRes);
                    adapter.notifyDataSetChanged();
                };
            };

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {};

            override fun onChildRemoved(snapshot: DataSnapshot) {};

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {};

            override fun onCancelled(error: DatabaseError) {};
        })


        binding.imgvBack.setOnClickListener { finish(); };
    }

    private fun addList(name: String, imgRes: Int) {
        databaseReference.child("messages/chat/$name").limitToLast(1).addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val dto = snapshot.getValue(MessageMainDTO::class.java);
                var isCheck = true;
                for (i in list.indices) {
                    if (list[i].name == dto?.name) {
                        list[i].content = dto.content;
                        isCheck = false;
                        break;
                    };
                };
                if (isCheck) {
                    list.add(MessageMainDTO(imgRes, name, dto?.content ?: "", dto?.date ?: "", true));
                };
                adapter.notifyDataSetChanged();
            };

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {};

            override fun onChildRemoved(snapshot: DataSnapshot) {};

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {};

            override fun onCancelled(error: DatabaseError) {};
        })
    }
}