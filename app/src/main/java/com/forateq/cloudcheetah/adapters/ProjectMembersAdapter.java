package com.forateq.cloudcheetah.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.forateq.cloudcheetah.R;
import com.forateq.cloudcheetah.models.ProjectMembers;
import com.forateq.cloudcheetah.models.Users;

import java.util.List;

/**
 * Created by Vallejos Family on 5/25/2016.
 */
public class ProjectMembersAdapter extends RecyclerView.Adapter<ProjectMembersAdapter.ViewHolder>{

    private List<ProjectMembers> listProjectMembers;
    private Context mContext;
    public static final String TAG = "ProjectMembersAdapter";

    public ProjectMembersAdapter(List<ProjectMembers> listProjectMembers, Context context) {
        this.listProjectMembers = listProjectMembers;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_contact, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final ProjectMembers projectMembers = listProjectMembers.get(i);
        Users users = Users.getUser(projectMembers.getUser_id());
        viewHolder.contactNameTV.setText(users.getFull_name());
        viewHolder.contactUsernameTV.setText(users.getUser_name());
        viewHolder.contactUserIdTV.setText(""+projectMembers.getUser_id());

    }

    @Override
    public int getItemCount() {
        return listProjectMembers == null ? 0 : listProjectMembers.size();
    }

    public void removeItem(int user_id){
        for(ProjectMembers projectMembers : listProjectMembers){
            if(projectMembers.getUser_id() == user_id){
                listProjectMembers.remove(projectMembers);
                notifyDataSetChanged();
            }
        }
    }

    public void clearItems(){
        listProjectMembers.clear();
        notifyDataSetChanged();
    }

    public void addItem(ProjectMembers projectMembers){
        listProjectMembers.add(projectMembers);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView contactNameTV;
        TextView contactUsernameTV;
        TextView contactUserIdTV;
        MaterialRippleLayout rippleLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            contactNameTV = (TextView) itemView.findViewById(R.id.contact_name);
            contactUsernameTV = (TextView) itemView.findViewById(R.id.contact_username);
            contactUserIdTV = (TextView) itemView.findViewById(R.id.user_id);
            rippleLayout = (MaterialRippleLayout) itemView.findViewById(R.id.ripple);
            rippleLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

    }


}
