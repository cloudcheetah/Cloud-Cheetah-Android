package com.forateq.cloudcheetah.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Vallejos Family on 5/25/2016.
 */
@Table(name = "ProjectResources")
public class ProjectResources extends Model {

    @Column(name = "project_id")
    int project_id;
    @Column(name = "project_offline_id")
    long project_offline_id;
    @Column(name = "resource_id")
    int resource_id;
    @Column(name = "quantity")
    int quantity;

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getProject_offline_id() {
        return project_offline_id;
    }

    public void setProject_offline_id(long project_offline_id) {
        this.project_offline_id = project_offline_id;
    }

    public static List<ProjectResources> getResources(int project_id){
        return new Select().from(ProjectResources.class).where("project_id = ?", project_id).execute();
    }

    public static List<ProjectResources> getResourcesOffline(long project_offline_id){
        return new Select().from(ProjectResources.class).where("project_offline_id = ?", project_offline_id).execute();
    }


}
