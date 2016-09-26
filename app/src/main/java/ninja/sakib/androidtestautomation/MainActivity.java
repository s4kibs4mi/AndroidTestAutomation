package ninja.sakib.androidtestautomation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * := Coded with love by Sakib Sami on 9/26/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    private Button nextBtn;
    private EditText mainText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = (EditText) findViewById(R.id.mainTextField);
        nextBtn = (Button) findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, PreviewActivity.class);
        i.putExtra("mainText", mainText.getText().toString());
        startActivity(i);
    }
}
