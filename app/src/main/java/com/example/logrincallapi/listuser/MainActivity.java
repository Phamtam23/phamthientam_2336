package com.example.logrincallapi.listuser;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.logrincallapi.Login;
import com.example.logrincallapi.R;
import com.example.logrincallapi.user;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundleReceive=getIntent().getExtras();
        ArrayList<user> listUser = getIntent().getParcelableArrayListExtra("keyalluser");
        if (listUser != null) {
            Toast.makeText(MainActivity.this, "số lượng phần tử: "+listUser.size()+" tên 1:"+listUser.get(0).getTennguoidung(), Toast.LENGTH_SHORT).show();
        }

        ListView listViewUsers = findViewById(R.id.lvuser);

        // Gắn adapter cho ListView
        UserAdapter adapter = new UserAdapter(this, listUser);
        listViewUsers.setAdapter(adapter);

    }
}