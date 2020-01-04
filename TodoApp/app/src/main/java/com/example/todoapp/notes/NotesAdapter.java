package com.example.todoapp.notes;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.todoapp.data.source.local.TodoContract.TodoEntry;


import com.example.todoapp.R;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {
    static String TAG = NotesAdapter.class.getSimpleName();
    Cursor mCursor;
    LayoutInflater mLayoutInflater;
    NotesAdapter mNotesAdapter;
    int titleColIndex;
    int subtitleColIndex;


    public NotesAdapter(Cursor cursor, Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mCursor = cursor;
        titleColIndex = mCursor.getColumnIndexOrThrow(TodoEntry.COLUMN_NAME_TITLE);
        subtitleColIndex = mCursor.getColumnIndexOrThrow(TodoEntry.COLUMN_NAME_SUBTITLE);

    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rowView = mLayoutInflater.inflate(R.layout.rv_row,viewGroup,false);
        return new NoteViewHolder(rowView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder noteViewHolder, int rowPosition) {
        /*Log.i(TAG,"rowposition="+rowPosition+
                "cursorposition="+mCursor.getPosition()+
                "title="+mCursor.getString(titleColIndex)+
                "subtitle="+mCursor.getString(subtitleColIndex));*/
        mCursor.moveToPosition(rowPosition);
        noteViewHolder.titleTextView.setText(mCursor.getString(titleColIndex));
        noteViewHolder.subtitleTextView.setText(mCursor.getString(subtitleColIndex));
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView subtitleTextView;
        public NoteViewHolder(@NonNull View rowView, NotesAdapter adapter) {
            super(rowView);
            mNotesAdapter = adapter;
            titleTextView = rowView.findViewById(R.id.textViewtitle);
            subtitleTextView = rowView.findViewById(R.id.textViewsubtitle);
        }
    }
}
