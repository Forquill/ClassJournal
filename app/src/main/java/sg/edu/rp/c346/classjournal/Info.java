package sg.edu.rp.c346.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class Info extends AppCompatActivity {

    int requestCodeForC347 = 1;
    int requestCodeForC302 = 2;

    ListView lvData;
    ArrayAdapter aa, aa2;
    Button btnInfo , btnAdd, btnEmail;
    ArrayList<Data> dataArray = new ArrayList<Data>();
    ArrayList<Data> dataArray2 = new ArrayList<Data>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent i = getIntent();
        final String moduleName = i.getStringExtra("positionCode");

        this.setTitle("Info for " + moduleName);

        btnInfo = (Button) findViewById(R.id.btnInfo);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnEmail = (Button) findViewById(R.id.btnEmail);
        lvData = (ListView) findViewById(R.id.lvInfo);

        dataArray.add(new Data("1","B"));
        dataArray.add(new Data("2", "C"));
        dataArray.add(new Data("3","A"));

        dataArray2.add(new Data("1","B"));
        dataArray2.add(new Data("2", "A"));

        if (moduleName.contentEquals("C347")){
            aa = new ClassAdapter(Info.this,R.layout.row, dataArray);
            lvData.setAdapter(aa);
        }else{
            aa2 = new ClassAdapter(Info.this,R.layout.row, dataArray2);
            lvData.setAdapter(aa2);
        }


        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (moduleName.contentEquals("C347")){
                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C347"));
                    startActivity(rpIntent);
                }else{
                    Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                    rpIntent.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C302"));
                    startActivity(rpIntent);
                }
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"jason_lim@rp.edu.sg"});
                String comment = "";
                for (int i = 0; i < dataArray.size();i++){
                    String week = dataArray.get(i).getWeek();
                    String grade = dataArray.get(i).getGrade();

                    comment += "Week " + week + ": DG: " + grade + "\n";
                }
                email.putExtra(Intent.EXTRA_TEXT, "Hi faci,\n\nI am ...\nPlease see my remarks so far,thank you!\n\n" + comment);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"Choose an Email client: "));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Info.this,AddData.class);
                if (moduleName.contentEquals("C347")){
                    int size = (int) dataArray.size();
                    String strSize = Integer.toString(size + 1);
                    i.putExtra("size",strSize);
                    startActivityForResult(i,requestCodeForC347);
                }else{
                    int size = (int) dataArray2.size();
                    String strSize = Integer.toString(size + 1);
                    i.putExtra("size",strSize);
                    startActivityForResult(i,requestCodeForC302);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data != null) {
                Data newData = (Data) data.getSerializableExtra("data");
                if (requestCode == requestCodeForC347) {
                    dataArray.add(new Data(newData.getWeek(), newData.getGrade()));
                    aa = new ClassAdapter(Info.this,R.layout.row, dataArray);
                    lvData.setAdapter(aa);
                }else if (requestCode == requestCodeForC302){
                    dataArray2.add(new Data(newData.getWeek(), newData.getGrade()));
                    aa = new ClassAdapter(Info.this,R.layout.row, dataArray2);
                    lvData.setAdapter(aa2);
                }else{

                }
            }
        }

    }
}
