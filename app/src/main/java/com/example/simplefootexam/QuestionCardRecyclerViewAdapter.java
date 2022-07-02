package com.example.simplefootexam;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.simplefootexam.model.Question;

import java.util.List;


/**
 * {@link RecyclerView.Adapter} that can display a {@link Question}.
 * TODO: Replace the implementation with code for your data type.
 */
public class QuestionCardRecyclerViewAdapter extends RecyclerView.Adapter<QuestionCardRecyclerViewAdapter.QuestionViewHolder> {

    private final List<Question> mValues;


    public QuestionCardRecyclerViewAdapter(List<Question> items) {
        mValues = items;
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_question_item, parent, false);
        return new QuestionViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final QuestionViewHolder holder, int position) {
        holder.mIdView.setText(mValues.get(position).id);
        holder.mImageView.setImageBitmap( BitmapFactory.decodeResource(holder.mView.getResources(), mValues.get(position).image_id));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(160, 160);
        holder.mImageView.setLayoutParams(layoutParams);
        //holder.mImageView.setImageBitmap(null);
        //Glide.with(holder.mView).load(mValues.get(position).image_id).into(holder.mImageView);
        holder.mQuestionview.setText(mValues.get(position).question);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("question", mValues.get(position));
                Navigation.findNavController(view).navigate(R.id.selectQuestionAction, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder{
        public final View mView;
        public final TextView mIdView;
        public final TextView mQuestionview;
        public final ImageView mImageView;

        public QuestionViewHolder(View view) {
            super(view);
            mView = view;
            mIdView =  view.findViewById(R.id.text_question_id);
            mImageView = view.findViewById(R.id.cardimage);
            mQuestionview = view.findViewById(R.id.text_question);

        }
    }
}