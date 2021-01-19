package com.salmaapp.tp32;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;


public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LinkedList<String> mWordList;
    private final LinkedList<String> description;
    private final LayoutInflater mInflater;
    private Context context;
    class WordViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public final TextView wordItemView;
        public final TextView descriptionView;
        final WordListAdapter mAdapter;


        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.recipe);
            descriptionView=itemView.findViewById(R.id.description);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            String i=Integer.toString(mPosition);
            // Use that to access the affected item in mWordList.
            //String element = mWordList.get(mPosition);
            // Change the word in the mWordList.
            Intent intent =new Intent(context, MainActivity2.class);
            intent.putExtra("index",i);
            context.startActivity(intent);


        }
    }

    public WordListAdapter(Context con, LinkedList<String> wordList,LinkedList<String> description) {
        context=con;
        mInflater = LayoutInflater.from(con);
        this.mWordList = wordList;
        this.description=description;
    }


    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // Inflate an item view.
        View mItemView = mInflater.inflate(
                R.layout.word_list_adapter, parent, false);
        return new WordViewHolder(mItemView, this);
    }


    @Override
    public void onBindViewHolder(WordViewHolder holder,
                                 int position) {
        // Retrieve the data for that position.
        String mCurrent = mWordList.get(position);
        String dCurrent = description.get(position) ;
        // Add the data to the view holder.
        holder.wordItemView.setText(mCurrent);
        holder.descriptionView.setHint(dCurrent);
    }


    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}