package work.VoucherApp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import work.VoucherApp.DAO.UserDAO;

public class RegisterActivity extends AppCompatActivity {
    private final ExecutorService executorService= Executors.newSingleThreadExecutor();
    private final Handler handler=new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        EditText editTextUsername=findViewById(R.id.register_username);
        EditText editTextPassword=findViewById(R.id.register_password);
        EditText editTextConfirmPassword=findViewById(R.id.register_repeat_password);
        Button buttonRegister=findViewById(R.id.register_button);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=editTextUsername.getText().toString();
                String password=editTextPassword.getText().toString();
                String confirmPassword=editTextConfirmPassword.getText().toString();
                if (password.equals(confirmPassword)) {
                    executorService.execute(new Runnable() {
                        @Override
                        public void run() {
                            UserDAO userDAO=new UserDAO();
                            boolean flag=userDAO.register(username, password);
                            handler.post(()->
                            {
                                if (flag) {
                                    Toast.makeText(RegisterActivity.this, "Registration Success", Toast.LENGTH_SHORT).show();
                                    finish();
                                }else {
                                    Toast.makeText(RegisterActivity.this, "Registration Failed,try different username", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                }else{
                    Toast.makeText(RegisterActivity.this, "Password Mismatch", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        executorService.shutdown();
    }
}
