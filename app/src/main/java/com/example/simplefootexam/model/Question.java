package com.example.simplefootexam.model;

import com.example.simplefootexam.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Question {
    public final String id;
    public final String question;
    public final String answer;
    public final int image_id;
    public String[] alternatives = new String[4];

    public Question(String id, int image_id) {
        this.id = id;
        this.image_id = image_id;
        this.question = "?";
        this.answer = "?";
    }
    public Question(String id, String question, int image_id, String answer) {
        this.id = id;
        this.image_id = image_id;
        this.question = question;
        this.answer = answer;
    }

    public Question(int id, JSONObject jo) throws JSONException, NoSuchFieldException, IllegalAccessException {
        this.id = String.valueOf(id);
        this.question = jo.getString("question");
        this.image_id =  R.drawable.class.getField(jo.getString("image")).getInt(null);  ;
        JSONArray alts = jo.getJSONArray("alternatives");
        this.answer = alts.length()>0 ? alts.getString(0) : "?";
        for (int i = 0; i < alts.length() && i < 4; i++) {
            this.alternatives[i] = alts.get(i).toString();
        }
    }

    @Override
    public String toString() {
        return question + id;
    }
}
