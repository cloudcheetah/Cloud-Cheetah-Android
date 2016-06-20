package com.forateq.cloudcheetah.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.forateq.cloudcheetah.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Vallejos Family on 6/10/2016.
 */
public class ResourceRowView extends LinearLayout {

    @Bind(R.id.resource_name)
    TextView resourceNameTV;
    @Bind(R.id.resource_quantity)
    TextView resourceQuantityTV;

    public ResourceRowView(Context context) {
        super(context);
        init();
    }

    public ResourceRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ResourceRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        inflate(getContext(), R.layout.resource_row_view, this);
        ButterKnife.bind(this);
    }

    public TextView getResourceNameTV() {
        return resourceNameTV;
    }

    public void setResourceNameTV(TextView resourceNameTV) {
        this.resourceNameTV = resourceNameTV;
    }

    public TextView getResourceQuantityTV() {
        return resourceQuantityTV;
    }

    public void setResourceQuantityTV(TextView resourceQuantityTV) {
        this.resourceQuantityTV = resourceQuantityTV;
    }
}
