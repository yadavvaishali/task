package com.example.property_database;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>implements Filterable {
    private static List<Property> dataModelList;
    private List<Property> exampleListFull;
    Context context;



    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView tvFirstName;
        TextView tvContactNo;
        TextView id;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition = getLayoutPosition();
                    Intent intent = new Intent (view.getContext(), MainActivity4.class);
                    String itemid= dataModelList.get(itemPosition).getId();
                    intent.putExtra("itemid",itemid );
                    view.getContext().startActivity(intent);
                }
            });

            tvFirstName = itemView.findViewById(R.id.namel);
            tvContactNo = itemView.findViewById(R.id.locationl);
//            id=itemView.findViewById(R.id.id);
        }
    }

    public RecyclerViewAdapter(Context context, List<Property> dataModelList) {
        this.context=context;
        this.dataModelList = dataModelList;
        exampleListFull=new ArrayList<>(dataModelList);

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
       Property property=dataModelList.get(position);
        holder.tvFirstName.setText(property.getName());
        holder.tvContactNo.setText(property.getLocation());
//        holder.id.setText(property.getId());

    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Property> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Property item : exampleListFull) {
                    if (item.getLocation().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dataModelList.clear();
            dataModelList.addAll((List) results.values);
            notifyDataSetChanged();
            if(dataModelList.size() == 0) {
                Toast.makeText(context, "Not Found", Toast.LENGTH_LONG).show();
            }
        }
    };

}
