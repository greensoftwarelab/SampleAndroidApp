package com.example.simplefootexam.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.simplefootexam.R;
import com.example.simplefootexam.model.Question;
import com.example.simplefootexam.utils.Utils;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionViewModel extends AndroidViewModel {

    private Map<String,Question> questions =  new HashMap<>();


    public QuestionViewModel(@NonNull Application application) {
        super(application);
        this.initQuestions(application.getApplicationContext());
    }

    private void initQuestions(Context ctx){
       JSONArray jsonArray = Utils.loadSONFile(ctx);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jo = null;
            try {
                jo = jsonArray.getJSONObject(i);
                Question q = new Question(i, jo);
                questions.put(q.id, q);
            } catch (JSONException | NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }


    public List<Question> getQuestions(){
        return new ArrayList<>(this.questions.values());
    }


}
