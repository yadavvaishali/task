package com.example.property_database;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RealstaesAdapter extends RecyclerView.Adapter<RealstaesAdapter.RecyclerViewHolder> implements Filterable {
    private static List<Property> dataModelList;
    private List<Property> exampleListFull;
    Context context;
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
                    Intent intent = new Intent (view.getContext(), Show_Realestate.class);
                    String itemid= dataModelList.get(itemPosition).getRealid();
                    intent.putExtra("itemid",itemid );
                    view.getContext().startActivity(intent);
                }
            });

            tvFirstName = itemView.findViewById(R.id.namel);
            tvContactNo = itemView.findViewById(R.id.locationl);
//            id=itemView.findViewById(R.id.id);
        }
    }

    public RealstaesAdapter(Context context, List<Property> dataModelList) {
        this.context=context;
        this.dataModelList = dataModelList;
        exampleListFull=new ArrayList<>(dataModelList);

    }
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
        holder.tvFirstName.setText(property.getReal_Name());
        holder.tvContactNo.setText(property.getLocation_real());
    }
    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;    }
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Property> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Property item : exampleListFull) {
                    if (item.getLocation_real().toLowerCase().contains(filterPattern)) {
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
