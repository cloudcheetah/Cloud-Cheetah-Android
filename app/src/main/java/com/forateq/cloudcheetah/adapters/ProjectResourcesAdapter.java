package com.forateq.cloudcheetah.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.forateq.cloudcheetah.R;
import com.forateq.cloudcheetah.models.ProjectResources;
import com.forateq.cloudcheetah.models.Resources;

import java.util.List;

/**
 * Created by Vallejos Family on 5/25/2016.
 */
public class ProjectResourcesAdapter extends RecyclerView.Adapter<ProjectResourcesAdapter.ViewHolder>{

    private List<ProjectResources> listProjectResources;
    private Context mContext;
    public static final String TAG = "ProjectResourcesAdapter";

    public ProjectResourcesAdapter(List<ProjectResources> listProjectResources, Context context) {
        this.listProjectResources = listProjectResources;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_resources, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final ProjectResources projectResources = listProjectResources.get(i);
        Resources resources = Resources.getResource(projectResources.getResource_id());
        viewHolder.resourceNameTV.setText(resources.getName());
        viewHolder.resourceQuantityTV.setText(""+projectResources.getQuantity()+" pcs.");
        viewHolder.resourcetIdTV.setText(""+projectResources.getResource_id());

    }

    @Override
    public int getItemCount() {
        return listProjectResources == null ? 0 : listProjectResources.size();
    }

    public void removeItem(int resource_id){
        for(ProjectResources projectResources : listProjectResources){
            if(projectResources.getResource_id() == resource_id){
                listProjectResources.remove(projectResources);
                notifyDataSetChanged();
            }
        }
    }

    public void clearItems(){
        listProjectResources.clear();
        notifyDataSetChanged();
    }

    public void addItem(ProjectResources projectResources){
        listProjectResources.add(projectResources);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView resourceNameTV;
        TextView resourceQuantityTV;
        TextView resourcetIdTV;
        MaterialRippleLayout rippleLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            resourceNameTV = (TextView) itemView.findViewById(R.id.resource_name);
            resourceQuantityTV = (TextView) itemView.findViewById(R.id.resource_quantity);
            resourcetIdTV = (TextView) itemView.findViewById(R.id.resource_id);
            rippleLayout = (MaterialRippleLayout) itemView.findViewById(R.id.ripple);
            rippleLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

    }
}
