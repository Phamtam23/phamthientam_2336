package com.example.logrincallapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.logrincallapi.listuser.MainActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private EditText editUsername;
    private EditText editpass;
    private Button btnLogin;
    private TextView xem;
    private List<user> mListuser;
    private List<user> listUser = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    editUsername=findViewById(R.id.edt_username);
    btnLogin=findViewById(R.id.buttonSubmit);
    xem =findViewById(R.id.xemall);
    //getListUser();
    btnLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            callGetInfoApi(editUsername.getText().toString());
        }
    });

    xem.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            callgetalluser();

        }
    });
    }




    ///gethoso

    private void callGetInfoApi(String idnguoidung) {
        api.apiService.getinf(idnguoidung).enqueue(new Callback<user2>() {
            @Override
            public void onResponse(Call<user2> call, Response<user2> response) {
                if (response.isSuccessful() && response.body() != null) {
                    user2 userInfo = response.body();
                    // Hiển thị thông tin hoặc xử lý dữ liệu
                    Toast.makeText(Login.this, "Tên: " + userInfo.getTen(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login.this, "Lỗi: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<user2> call, Throwable t) {
                Toast.makeText(Login.this, "Kết nối thất bại: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callgetalluser() {
        api.apiService.getAll().enqueue(new Callback<List<user>>() {
            @Override
            public void onResponse(Call<List<user>> call, Response<List<user>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Gán dữ liệu vào listUser
                    listUser = response.body();
                    Toast.makeText(Login.this, "Lấy dữ liệu thành công!", Toast.LENGTH_SHORT).show();
                    // Xử lý dữ liệu hoặc cập nhật giao diện nếu cần
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    intent.putExtra("keyalluser", (ArrayList<user>)listUser);
                    //Toast.makeText(Login.this, "số lượng phần tử truyền đi: "+listUser.size()+" tên 1:"+listUser.get(0).getTen(), Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Không có dữ liệu trả về!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<user>> call, Throwable t) {
                Toast.makeText(Login.this, "Lỗi khi gọi API: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}