package com.example.simplefootexam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.hunter.library.debug.HunterDebug;
import android.content.Context;

public class MainMenuFragment extends Fragment {

    @Override
    @HunterDebug
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @HunterDebug
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainMenuFragment.this).navigate(R.id.action_FirstFragment_to_QuestionFragment);
            }
        });
    }
}
