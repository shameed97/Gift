package com.example.gift;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListviewAdapter extends ArrayAdapter {

    private ArrayList<detail> list = new ArrayList<>();

    public ListviewAdapter(Context context, int resource, ArrayList<detail> list) {
        super(context, resource);
        this.list = list;
    }


    public List<String> add(detail object) {
        list.add(object);
        super.add(object);
        return null;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ProductHolder productHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.detail_list, parent, false);
            productHolder = new ProductHolder();
            productHolder.tx_id = row.findViewById(R.id.tno);
            productHolder.tx_name = row.findViewById(R.id.tName);
            productHolder.tx_fam = row.findViewById(R.id.tFamily);
            productHolder.tx_city = row.findViewById(R.id.tCity);
            productHolder.tx_pre = row.findViewById(R.id.tPresent);
            row.setTag(productHolder);
        } else {
            productHolder = (ProductHolder) row.getTag();
        }

        detail det = (detail) getItem(position);
        productHolder.tx_id.setText(String.valueOf(det.getId()));
        productHolder.tx_name.setText(det.getName());
        productHolder.tx_fam.setText(det.getFam());
        productHolder.tx_city.setText(det.getCity());
        productHolder.tx_pre.setText(det.getPresent());
        return row;


    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    static class ProductHolder {
        TextView tx_id, tx_name, tx_fam, tx_city, tx_pre;
    }

    public void update(ArrayList<detail> newList) {
        list = new ArrayList<>();
        list.addAll(newList);
        notifyDataSetChanged();
    }
}
