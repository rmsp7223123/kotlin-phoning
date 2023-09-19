package com.example.phoning.message

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phoning.HideActionBar
import com.example.phoning.R
import com.example.phoning.databinding.ActivityMessageChatBinding
import com.example.phoning.dto.MessageMainDTO
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MessageChatActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMessageChatBinding;
    private val list: ArrayList<MessageMainDTO> = ArrayList();
    private val firebaseDatabase = FirebaseDatabase.getInstance();
    private val databaseReference = firebaseDatabase.getReference("messages");
    private var isChatCheck = false;
    private var messageId = "";
    private var chatDTO: MessageMainDTO? = null;

    private val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault());
    private val currentTime = dateFormat.format(Date());


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityMessageChatBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val hideActionBar = HideActionBar();
        hideActionBar.hideActionBar(this);

        val messageMainDTO = intent.getSerializableExtra("dto") as MessageMainDTO;
        val itemName = messageMainDTO.name;

        binding.tvName.text = messageMainDTO.name;
        binding.imgvFace.setImageResource(messageMainDTO.imgRes);

        val adapter = MessageChatAdapter(list, this, isChatCheck, databaseReference);
        binding.recv.adapter = adapter;
        binding.recv.layoutManager = LinearLayoutManager(this);


        binding.imgvSend.setOnClickListener {
            val messageText = binding.edtMessage.text.toString();
            if (messageText.isNotEmpty()) {
                val name = intent.getStringExtra("name");
                val imgRes = intent.getIntExtra("img", 0);
                messageId = databaseReference.child("chat").child(itemName).push().key!!;
                chatDTO = MessageMainDTO(imgRes, name!!, messageText, currentTime, true);
                databaseReference.child("chat").child(itemName).child(messageId).setValue(chatDTO);
                adapter.notifyDataSetChanged();
                binding.edtMessage.setText("");
            };
        };

        databaseReference.child("chat").child(itemName).addChildEventListener(object :
            ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {
                val chatDTO = dataSnapshot.getValue(MessageMainDTO::class.java)
                chatDTO?.imgRes = messageMainDTO.imgRes
                adapter.addData(chatDTO!!)
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, s: String?) {}

            override fun onChildRemoved(dataSnapshot: DataSnapshot) {
                val chatDTO = dataSnapshot.getValue(MessageMainDTO::class.java)
                adapter.removeData(chatDTO!!)
            }

            override fun onChildMoved(dataSnapshot: DataSnapshot, s: String?) {}

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
}