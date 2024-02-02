package work.VoucherApp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SubmitFeedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_feedback.xml layout file
        setContentView(R.layout.submit_feedback);

        // Here you can initialize your views and set up listeners for the submit button
        // For example, you might use findViewById to get a reference to the EditText and Button views
    }
}