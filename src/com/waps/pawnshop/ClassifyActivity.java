package com.waps.pawnshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

public class ClassifyActivity extends ExpandableListActivity {
    /** Called when the activity is first created. */ 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // parent list
        List<Map<String, Object>> parentList = new ArrayList<Map<String,Object>>();

        // child list
        // 
        List<List<Map<String, Object>>> allChildList = new ArrayList<List<Map<String,Object>>>();

        // create 3 parent
        for(int i = 0; i < 3; i++){
            //  Map of parent
        	
            Map<String, Object> parentData = new HashMap<String, Object>();

            // create parent's title
            parentData.put("TITLE", "Parent" + i);

            // set Map list
            parentList.add(parentData);

            // every parent create 5 child
            List<Map<String, Object>> childList = new ArrayList<Map<String,Object>>();
            for(int j = 0; j < 5; j++){
                // create child's title 
                Map<String, Object> childData = new HashMap<String, Object>();
                childData.put("TITLE", "Second" + j);
                childData.put("SUMMARY", "summary" + j);
                childList.add(childData);
            }

            // all child set
            allChildList.add(childList);
        }

        // create adapter
        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                parentList,
                android.R.layout.simple_expandable_list_item_1,
                new String []{"TITLE"},
                new int []{android.R.id.text1},
                allChildList,
                android.R.layout.simple_expandable_list_item_2,
                new String []{"TITLE", "SUMMARY"},
                new int []{android.R.id.text1, android.R.id.text2}
        );

        // Adapter set
        setListAdapter(adapter);

        // create child's OnChildClickListener
        ExpandableListView listView = getExpandableListView();
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener(){

            /** child click method */
            @SuppressWarnings("unchecked")
            @Override
            public boolean onChildClick(
                    ExpandableListView parent,
                    View v,
                    int groupPosition,
                    int childPosition,
                    long id)
            {
                // get parent data
                ExpandableListAdapter adapter = parent.getExpandableListAdapter();

                // get child data
                Map<String, Object> childMap = (Map<String, Object>)adapter.getChild(
                        groupPosition,
                        childPosition
                );

                // output log
                Log.d("SampleActivity", "TITLE: " + childMap.get("TITLE"));
                Log.d("SampleActivity", "SUMMARY: " + childMap.get("SUMMARY"));

                return false;
            }
        });
    }
}