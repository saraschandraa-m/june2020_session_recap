package in.appstone.sessionrecap;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChatListActivity extends AppCompatActivity {

    //1. onCreate
    //2. onStart
    //3. onResume
    //4. onPause
    //5. onStop
    //6. onDestroy
    //7. onRestart


    private String TAG = "Activity-ChatList";
    private EditText etEmailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate");


        etEmailAddress = findViewById(R.id.et_email_address);
        final EditText etpassword = findViewById(R.id.et_password);

        Button btnChatDetail = findViewById(R.id.btn_chat_detail);
        Button btnChatDetailwithResult = findViewById(R.id.btn_chat_detail_result);
        Button btnProfileWithResult = findViewById(R.id.btn_profile_result);

        btnChatDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = etEmailAddress.getText().toString();
                String password = etpassword.getText().toString();

                Intent chatDetailIntent = new Intent(ChatListActivity.this, ChatDetailActivity.class);
                chatDetailIntent.putExtra("EMAIL", email);
                chatDetailIntent.putExtra("PASSWORD", password);
                startActivity(chatDetailIntent);
            }
        });

        btnChatDetailwithResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmailAddress.getText().toString();
                String password = etpassword.getText().toString();

                Intent chatDetailIntent = new Intent(ChatListActivity.this, ChatDetailActivity.class);
                chatDetailIntent.putExtra("EMAIL", email);
                chatDetailIntent.putExtra("PASSWORD", password);
                startActivityForResult(chatDetailIntent, 945);
            }
        });

        btnProfileWithResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(ChatListActivity.this, ProfileActivity.class);
                startActivityForResult(profileIntent, 125);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 945) {
            if(resultCode == Activity.RESULT_OK) {
                String email = data.getStringExtra("EMAIL");
                etEmailAddress.setText(email);
            }else{
                Toast.makeText(ChatListActivity.this, "user cancelled operation", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }
}