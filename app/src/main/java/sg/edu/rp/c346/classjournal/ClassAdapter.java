package sg.edu.rp.c346.classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ClassAdapter extends ArrayAdapter {
    private ArrayList<Data> info;
    private Context context;
    private TextView tvWeek,tvGrade;

    public ClassAdapter(Context context, int resource, ArrayList objects){
        super(context, resource, objects);
        info = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvWeek = (TextView) rowView.findViewById(R.id.tvWeek);
        tvGrade = (TextView) rowView.findViewById(R.id.tvGrade);

        Data currInfo = info.get(position);

        tvWeek.setText(currInfo.toString());
        tvGrade.setText(currInfo.getGrade());

        return rowView;
    }
}
