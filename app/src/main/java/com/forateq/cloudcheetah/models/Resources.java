package com.forateq.cloudcheetah.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vallejos Family on 5/25/2016.
 */
@Table(name = "Resources")
public class Resources extends Model {

    @Column(name = "resource_id")
    int resource_id;
    @Column(name = "resource_name")
    String name;
    @Column(name = "resource_description")
    String description;
    @Column(name = "resource_parent_id")
    int parent_id;
    @Column(name = "resource_account_id")
    int account_id;
    @Column(name = "resource_type_id")
    int type_id;
    @Column(name = "resource_unit_of_measurement")
    String unit_of_measurement;
    @Column(name = "resource_unit_cost")
    double unit_cost;
    @Column(name = "resource_sales_price")
    double sales_price;
    @Column(name = "resource_reorder_point")
    String reorder_point;
    @Column(name = "resource_vendor_id")
    int vendor_id;
    @Column(name = "resource_notes")
    String notes;

    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public double getUnit_cost() {
        return unit_cost;
    }

    public void setUnit_cost(double unit_cost) {
        this.unit_cost = unit_cost;
    }

    public String getUnit_of_measurement() {
        return unit_of_measurement;
    }

    public void setUnit_of_measurement(String unit_of_measurement) {
        this.unit_of_measurement = unit_of_measurement;
    }

    public double getSales_price() {
        return sales_price;
    }

    public void setSales_price(double sales_price) {
        this.sales_price = sales_price;
    }

    public String getReorder_point() {
        return reorder_point;
    }

    public void setReorder_point(String reorder_point) {
        this.reorder_point = reorder_point;
    }

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public static Resources getResource(int resource_id){
        return new Select().from(Resources.class).where("resource_id = ?", resource_id).executeSingle();
    }

    public static int getAllResourceId(String resourceName) {
        Resources resources = new Select().from(Resources.class).where("resource_name = ?", resourceName).executeSingle();
        return  resources.getResource_id();
    }

    public static List<String> getAllResourcesList(){
        List<String> resourcesListString = new ArrayList<>();
        List<Resources> resourcesList = new Select().from(Resources.class).execute();
        for(Resources resources : resourcesList){
            resourcesListString.add(resources.getName());
        }
        return  resourcesListString;
    }
}
