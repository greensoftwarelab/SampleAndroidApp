package com.example.simplefootexam;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.simplefootexam.model.Question;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SingleQuestionFragment extends Fragment {

    private Question question;

    @BindView(R.id.button_top_left)
    Button buttonTopLeft;
    @BindView(value = R.id.button_top_right)
    Button buttonTopRight;
    @BindView(value = R.id.button_bottom_left)
    Button buttonBottomLeft;
    @BindView(value = R.id.button_bottom_right)
    Button buttonBottomRight;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View v = inflater.inflate(R.layout.fragment_single_question, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Question q = getArguments().getParcelable("question");
        setQuestion(q);

    }

    private void setQuestion(Question quest) {
        question = quest;
        List<String> l = Arrays.asList(quest.alternatives);
        Collections.shuffle(l);
        buttonTopLeft.setText(l.get(0));
        buttonTopRight.setText(l.get(1));
        buttonBottomLeft.setText(l.get(2));
        buttonBottomRight.setText(l.get(3));
    }
}
