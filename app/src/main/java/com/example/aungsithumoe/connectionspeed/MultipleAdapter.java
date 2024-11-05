package com.example.aungsithumoe.connectionspeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aungsithumoe on 1/8/18.
 */

public class MultipleAdapter extends BaseAdapter implements SelectedIndex{
    Context context;
    List<MultipleData> mList;

    public MultipleAdapter(Context context, List<MultipleData> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(R.layout.list_item,parent,false);
        TextView textView=(TextView)rowView.findViewById(R.id.list_item_text);
        RadioButton radioButton=(RadioButton)rowView.findViewById(R.id.list_item_check_button);
        MultipleData multipleData=mList.get(position);
        textView.setText(multipleData.getName());
        radioButton.setChecked(multipleData.isSelected);
        return rowView;
    }

    @Override
    public void setSelectedIndex(int position) {
        if (mList.get(position).isSelected()) {
            mList.get(position).setSelected(false);
        } else {
            mList.get(position).setSelected(true);
        }
    }
}
