package com.asplett.uishowcaseapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class GridLayoutDemo extends Fragment {

    private GridView gridView;
    private String[] itemNames;
    private int[] itemImages = {
            R.drawable.grid1, R.drawable.grid2, R.drawable.grid3,
            R.drawable.grid4, R.drawable.grid5, R.drawable.grid6};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_layout_demo, container, false);

        gridView = view.findViewById(R.id.page3_grid_layout_demo);

        // Labels dos itens usando string resources
        itemNames = getResources().getStringArray(R.array.grid_item_labels);

        GridAdapter adapter = new GridAdapter();
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemName = itemNames[position];
                Toast.makeText(getActivity(), "Clicked: " + itemName, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    // Adapter para fornecer os itens do GridView
    private class GridAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return itemNames.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
            }

            ImageView imageView = convertView.findViewById(R.id.grid_item_image);
            TextView textView = convertView.findViewById(R.id.grid_item_label);

            imageView.setImageResource(itemImages[position]);
            textView.setText(itemNames[position]);

            return convertView;
        }
    }
}
