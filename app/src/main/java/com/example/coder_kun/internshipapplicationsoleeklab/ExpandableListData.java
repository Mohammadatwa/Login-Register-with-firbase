package com.example.coder_kun.internshipapplicationsoleeklab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListData {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();
        List<String> cricketPlayers = new ArrayList<String>();
        cricketPlayers.add("afhassad");
        cricketPlayers.add("bdasd");
        cricketPlayers.add("Villiers");
        cricketPlayers.add("Chris Gayle");
        cricketPlayers.add("Rohit Sharma");
        expandableListDetail.put("CRICKET PLAYERS",
                cricketPlayers);
        return expandableListDetail;
    }
}
