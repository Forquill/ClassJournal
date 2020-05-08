package sg.edu.rp.c346.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AddData extends AppCompatActivity {

    RadioGroup rgGrade;
    Button btnAdd;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        rgGrade = (RadioGroup) findViewById(R.id.rgGrade);
        btnAdd = (Button) findViewById(R.id.btnAddInput);

        Intent i = getIntent();
        final String size = i.getStringExtra("size");

        this.setTitle("Add data for Week " + size);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent();
                int selectedId = rgGrade.getCheckedRadioButtonId();
                rb = (RadioButton) findViewById(selectedId);
                Data newData = new Data(size,rb.getText().toString());
                a.putExtra("data", newData);
                setResult(RESULT_OK,a);
                finish();
            }
        });
    }
}
