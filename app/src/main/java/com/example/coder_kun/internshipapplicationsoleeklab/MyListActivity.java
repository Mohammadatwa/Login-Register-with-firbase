package com.example.coder_kun.internshipapplicationsoleeklab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyListActivity extends AppCompatActivity implements ExpandableListView.OnGroupExpandListener, ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnChildClickListener {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private List<CountryModel> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        expListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expListView.setOnGroupExpandListener(this);
        expListView.setOnGroupCollapseListener(this);
        expListView.setOnChildClickListener(this);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */

    private String[] letters = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S",
            "T", "U", "V", "W", "X", "Y", "Z"
    };

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        Intent intent = getIntent();
        countries = (List<CountryModel>) intent.getSerializableExtra("countryModelList");

        for(int index = 0; index < letters.length; index ++){
            listDataHeader.add(letters[index]);

            //check if i have the letter with this index
            List<String> countryWithLetterList = new ArrayList<String>();
            for (int countryIndex = 0; countryIndex < countries.size(); countryIndex++){
                Boolean hasLetter = countries.get(countryIndex).getCountry().startsWith(letters[index]);
                if(hasLetter == true) {
                    countryWithLetterList.add(countries.get(countryIndex).getCountry());
                }
            }

            //aray 1 headers //listDataHeader
            //array 2 countries // countryWithLetterList

            listDataChild.put(listDataHeader.get(index), countryWithLetterList);

        }

//        // Adding child data
//        listDataHeader.add("Top 250");
//        listDataHeader.add("Now Showing");
//        listDataHeader.add("Coming Soon..");






        // Adding child data
//        List<String> top250 = new ArrayList<String>();
//        top250.add("The Shawshank Redemption");
//        top250.add("The Godfather");
//        top250.add("The Godfather: Part II");
//        top250.add("Pulp Fiction");
//        top250.add("The Good, the Bad and the Ugly");
//        top250.add("The Dark Knight");
//        top250.add("12 Angry Men");
//
//        List<String> nowShowing = new ArrayList<String>();
//        nowShowing.add("The Conjuring");
//        nowShowing.add("Despicable Me 2");
//        nowShowing.add("Turbo");
//        nowShowing.add("Grown Ups 2");
//        nowShowing.add("Red 2");
//        nowShowing.add("The Wolverine");
//
//        List<String> comingSoon = new ArrayList<String>();
//        comingSoon.add("2 Guns");
//        comingSoon.add("The Smurfs 2");
//        comingSoon.add("The Spectacular Now");
//        comingSoon.add("The Canyons");
//        comingSoon.add("Europa Report");
//
//        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
//        listDataChild.put(listDataHeader.get(1), nowShowing);
//        listDataChild.put(listDataHeader.get(2), comingSoon);
    }


    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        return false;
    }

    @Override
    public void onGroupCollapse(int groupPosition) {

    }

    @Override
    public void onGroupExpand(int groupPosition) {

    }
}
