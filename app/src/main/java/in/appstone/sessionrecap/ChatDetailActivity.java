package in.appstone.sessionrecap;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChatDetailActivity extends AppCompatActivity {

    private String TAG = "Activity-ChatDetail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);
        Log.i(TAG, "onCreate");

        TextView mTvTitle = findViewById(R.id.tv_title);

        final EditText mEtEditEmail = findViewById(R.id.et_edit_email);


//        Bundle data = getIntent().getExtras();
//
//        String email = data.getString("EMAIL");
//        String password = data.getString("PASSWORD");

        String email = getIntent().getStringExtra("EMAIL");
        String password = getIntent().getStringExtra("PASSWORD");

        mTvTitle.setText(email.concat(" ").concat(password));
        mEtEditEmail.setText(email);

        Button btnProfile = findViewById(R.id.btn_profile);
        Button btnCloseAndMove = findViewById(R.id.btn_close_move_profile);
        Button btnMovebackWithResult = findViewById(R.id.btn_move_result);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(ChatDetailActivity.this, ProfileActivity.class));
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        btnCloseAndMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChatDetailActivity.this, ProfileActivity.class));
                finish();
            }
        });

        btnMovebackWithResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editedEmail = mEtEditEmail.getText().toString();

                Intent returnIntent = new Intent();
                returnIntent.putExtra("EMAIL", editedEmail);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });


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