package com.example.simplefootexam;

import androidx.recyclerview.widget.RecyclerView;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_question_item, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final QuestionViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mImageView.setImageBitmap( BitmapFactory.decodeResource(holder.mView.getResources(), mValues.get(position).image_id));
        holder.mQuestionview.setText(mValues.get(position).question);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class QuestionViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mQuestionview;
        public final ImageView mImageView;
        public Question mItem;

        public QuestionViewHolder(View view) {
            super(view);
            mView = view;
            mIdView =  view.findViewById(R.id.text_question_id);
            mImageView = view.findViewById(R.id.cardimage);
            mQuestionview = view.findViewById(R.id.text_question);
        }


    }
}