package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ChatListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChatUserAdapter chatUserAdapter;
    private List<User> users;
    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        recyclerView = findViewById(R.id.recyclerViewUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Example current user
        currentUser = new User("user1", "Me", null);

        // Example friend users
        users = new ArrayList<>();
        users.add(new User("user2", "Alice", null));
        users.add(new User("user3", "Bob", null));
        users.add(new User("user4", "Charlie", null));

        // Initialize adapter
        chatUserAdapter = new ChatUserAdapter(users, user -> {
            // On user click, go to ChattingActivity
            Intent intent = new Intent(ChatListActivity.this, ChattingActivity.class);
            intent.putExtra("currentUserId", currentUser.getUserId());
            intent.putExtra("friendUserId", user.getUserId());
            intent.putExtra("friendUserName", user.getName());
            startActivity(intent);
        });

        recyclerView.setAdapter(chatUserAdapter);
    }
}
