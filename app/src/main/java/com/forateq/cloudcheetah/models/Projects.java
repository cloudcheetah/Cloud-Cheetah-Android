package com.forateq.cloudcheetah.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.activeandroid.util.SQLiteUtils;

import java.util.List;

/**
 * Created by Vallejos Family on 5/13/2016.
 */
@Table(name="Projects")
public class Projects extends Model {

    @Column(name = "project_id")
    int project_id;
    @Column(name = "project_name")
    String name;
    @Column(name = "project_start_date")
    String start_date;
    @Column(name = "project_end_date")
    String end_date;
    @Column(name = "project_budget")
    double budget;
    @Column(name = "project_description")
    String description;
    @Column(name = "project_objectives")
    String objectives;
    @Column(name = "project_latitude")
    double latitude;
    @Column(name = "project_longitude")
    double longitide;
    @Column(name = "project_status")
    String status;
    @Column(name = "project_sponsor")
    String project_sponsor;
    @Column(name = "project_manager")
    String project_manager;

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitide() {
        return longitide;
    }

    public void setLongitide(double longitide) {
        this.longitide = longitide;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static List<Projects> getProjects(){
        return new Select().from(Projects.class).execute();
    }

    public String getProject_sponsor() {
        return project_sponsor;
    }

    public void setProject_sponsor(String project_sponsor) {
        this.project_sponsor = project_sponsor;
    }

    public String getProject_manager() {
        return project_manager;
    }

    public void setProject_manager(String project_manager) {
        this.project_manager = project_manager;
    }

    public static List<Projects> getSearchProject(String name){
        String [] selectionArgs = new String[] {"%" + name + "%"};
        List<Projects> searchItems =
                SQLiteUtils.rawQuery(Projects.class,
                        "SELECT * FROM Projects WHERE project_name  LIKE ?",
                        selectionArgs);
        return searchItems;
    }

    public static Projects getProjectById(int project_id){
        return new Select().from(Projects.class).where("project_id = ?", project_id).executeSingle();
    }

    public static Projects getProjectsOfflineMode(long id){
        return new Select().from(Projects.class).where("id = ?", id).executeSingle();
    }
}
