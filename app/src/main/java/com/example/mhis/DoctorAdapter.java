package com.example.mhis;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DoctorAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final List<String> items;

    public DoctorAdapter (Activity context, List<String> items) {
        super(context, R.layout.datas_list, items);
        this.context = context;
        this.items= items;

    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.datas_list, null, true);

        TextView doctorName = (TextView) rowView.findViewById(R.id.textView_Name);
        TextView doctorOffice= (TextView) rowView.findViewById(R.id.textView_Office);
        TextView doctorEmail= (TextView) rowView.findViewById(R.id.textView_Email);


        doctorName.setText(items.get(3*position));
        doctorOffice.setText(items.get(3*position + 1));
        doctorEmail.setText(items.get(3*position + 2));

        return rowView;
    }
}
