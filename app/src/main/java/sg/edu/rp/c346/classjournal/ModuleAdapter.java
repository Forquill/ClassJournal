package sg.edu.rp.c346.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleAdapter extends ArrayAdapter {
    private ArrayList<Module> module;
    private Context context;
    private TextView tvModuleCode,tvModuleName;

    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects){
        super(context, resource, objects);
        module = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.modulerow, parent, false);

        tvModuleCode = (TextView) rowView.findViewById(R.id.tvModuleCode);
        tvModuleName = (TextView) rowView.findViewById(R.id.tvModuleName);

        Module currModule = module.get(position);

        tvModuleName.setText(currModule.getModuleName());
        tvModuleCode.setText(currModule.getModule());

        return rowView;
    }
}
