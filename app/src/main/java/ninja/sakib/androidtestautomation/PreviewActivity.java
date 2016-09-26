package ninja.sakib.androidtestautomation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * := Coded with love by Sakib Sami on 9/26/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

public class PreviewActivity extends AppCompatActivity implements
        View.OnClickListener {
    private TextView passedText;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        passedText = (TextView) findViewById(R.id.passedText);
        saveBtn = (Button) findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(this);

        Bundle passedData = getIntent().getExtras();
        if (passedData != null) {
            passedText.setText(passedData.getString("mainText"));
        }
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Saved : " + passedText.getText().toString(),
                Toast.LENGTH_LONG).show();
    }
}
