package com.example.MNM;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class ChatActivity extends AppCompatActivity {

    //views from xml
    Toolbar toolbar;
    RecyclerView recyclerView;
    ImageView profileIv;
    TextView nameTv,userStatusTv;
    EditText massageEt;
    ImageButton sendBtn;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        recyclerView =findViewById(R.id.chat_recyclerVeiw);
        profileIv = findViewById(R.id.profileIcon);
        nameTv = findViewById(R.id.nameTV);
        userStatusTv = findViewById(R.id.userStatusTV);
        massageEt = findViewById(R.id.messageET);
        sendBtn = findViewById(R.id.sendBtn);

        firebaseAuth = FirebaseAuth.getInstance();
    }
}
