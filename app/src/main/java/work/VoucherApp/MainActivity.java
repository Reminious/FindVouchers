package work.VoucherApp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import work.VoucherApp.DAO.UserDAO;

public class MainActivity extends AppCompatActivity {
    private ExecutorService executorService= Executors.newSingleThreadExecutor();
    private Handler handler=new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login);

        Button buttonLogin = findViewById(R.id.login_button);
        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = usernameEditText.getText().toString();
                final String password = passwordEditText.getText().toString();
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        UserDAO userDAO = new UserDAO();
                        int msg = userDAO.login(username, password);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (msg == 1) {
                                    Intent intent = new Intent(MainActivity.this, FunctionsActivity.class);
                                    startActivity(intent);
                                } else if (msg == 2) {
                                    Toast.makeText(MainActivity.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                                } else if (msg == 3) {
                                    Toast.makeText(MainActivity.this, "Admin login", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "User does not exist", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        executorService.shutdown();
    }
}