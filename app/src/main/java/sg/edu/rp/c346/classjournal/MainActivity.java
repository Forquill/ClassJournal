package sg.edu.rp.c346.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvModule;
    ArrayList<Module> module;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModule = (ListView) findViewById(R.id.lvModule);

        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(MainActivity.this,Info.class);
                i.putExtra("positionNum",position);
                i.putExtra("positionName",module.get(position).getModuleName());
                i.putExtra("positionCode",module.get(position).getModule());
                startActivity(i);
            }
        });

        module = new ArrayList<Module>();

        module.add(new Module("C302","Web Services"));
        module.add(new Module("C347","Android Programming ll"));

        ArrayAdapter aa = new ModuleAdapter(MainActivity.this,R.layout.modulerow,module);
        lvModule.setAdapter(aa);
    }
}
