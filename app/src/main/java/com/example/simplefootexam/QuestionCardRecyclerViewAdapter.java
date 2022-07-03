package com.example.simplefootexam;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.simplefootexam.model.Question;
import java.util.List;
import com.hunter.library.debug.HunterDebug;
import android.content.Context;

public class QuestionCardRecyclerViewAdapter extends RecyclerView.Adapter<QuestionCardRecyclerViewAdapter.QuestionViewHolder> {

    private final List<Question> mValues;

    @HunterDebug
    public QuestionCardRecyclerViewAdapter(List<Question> items) {
        mValues = items;
    }

    @Override
    @HunterDebug
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_question_item, parent, false);
        return new QuestionViewHolder(v);
    }

    @Override
    @HunterDebug
    public void onBindViewHolder(final QuestionViewHolder holder, int position) {
        holder.mIdView.setText(mValues.get(position).getId());
        holder.mImageView.setImageBitmap(BitmapFactory.decodeResource(holder.mView.getResources(), mValues.get(position).getImageId()));
        holder.mQuestionview.setText(mValues.get(position).getQuestion());
        holder.mView.setOnClickListener( view -> {
            Bundle bundle = new Bundle();
            bundle.putParcelable("question", mValues.get(position));
            Navigation.findNavController(view).navigate(R.id.selectQuestionAction, bundle);
        });
    }

    @Override
    @HunterDebug
    public int getItemCount() {
        return mValues.size();
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        public final TextView mIdView;

        public final TextView mQuestionview;

        public final ImageView mImageView;

        @HunterDebug
        public QuestionViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = view.findViewById(R.id.text_question_id);
            mImageView = view.findViewById(R.id.cardimage);
            mQuestionview = view.findViewById(R.id.text_question);
        }
    }
}
