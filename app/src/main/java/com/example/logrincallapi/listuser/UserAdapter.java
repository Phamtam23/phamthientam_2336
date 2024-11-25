package com.example.logrincallapi.listuser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.logrincallapi.R;
import com.example.logrincallapi.user;

import java.util.List;

public class UserAdapter extends ArrayAdapter<user> {
    public UserAdapter(Context context, List<user> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_item, parent, false);
        }

        user currentUser = getItem(position);

        TextView tvUserName = convertView.findViewById(R.id.tvUserName);
        TextView tvID = convertView.findViewById(R.id.id);
        TextView tvemail = convertView.findViewById(R.id.email);
        TextView pass = convertView.findViewById(R.id.pass);

        tvUserName.setText("Name: " + currentUser.getTennguoidung());
        tvID.setText("Phone: " + currentUser.getIdnguoidung());
        tvemail.setText("Email: " + currentUser.getEmail());
        pass.setText("Password: " + currentUser.getPassw());

        return convertView;
    }
}
