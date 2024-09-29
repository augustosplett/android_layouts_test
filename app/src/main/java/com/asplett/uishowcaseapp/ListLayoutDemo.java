package com.asplett.uishowcaseapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListLayoutDemo extends Fragment {

    private RecyclerView recyclerView;
    private List<String> itemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_layout_demo, container, false);

        // Inicializar RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Preencher a lista de itens (Ex: nomes de cidades)
        itemList = new ArrayList<>();
        itemList.add("New York");
        itemList.add("London");
        itemList.add("Tokyo");
        itemList.add("Paris");
        itemList.add("Berlin");
        itemList.add("Madrid");
        itemList.add("Rome");
        itemList.add("Sydney");
        itemList.add("Toronto");
        itemList.add("Beijing");

        // Configurar o adaptador
        ItemAdapter adapter = new ItemAdapter(itemList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    // Adaptador para RecyclerView
    private class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

        private List<String> items;

        public ItemAdapter(List<String> items) {
            this.items = items;
        }

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
            String itemName = items.get(position);
            holder.itemName.setText(itemName);

            // Configurar evento de clique no item
            holder.itemView.setOnClickListener(v ->
                    Toast.makeText(getActivity(), "Clicked: " + itemName, Toast.LENGTH_SHORT).show()
            );

            // Configurar evento de clique no switch
            holder.itemSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
                String status = isChecked ? "On" : "Off";
                Toast.makeText(getActivity(), itemName + " is " + status, Toast.LENGTH_SHORT).show();
            });
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        // ViewHolder interno
        public class ItemViewHolder extends RecyclerView.ViewHolder {
            TextView itemName;
            SwitchCompat itemSwitch;

            public ItemViewHolder(@NonNull View itemView) {
                super(itemView);
                itemName = itemView.findViewById(R.id.item_name);
                itemSwitch = itemView.findViewById(R.id.item_switch);
            }
        }
    }
}
