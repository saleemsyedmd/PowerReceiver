import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.databaseimplementationapp.Data.DbHelper;
import com.example.databaseimplementationapp.TodoDbHelper;
import com.example.databaseimplementationapp.TodoEntry;
import com.example.databaseimplementationapp.TodoNote;

public class DAO {

    DbHelper dbHelper;
    SQLiteDatabase database;

    public DAO(Context context){

        dbHelper = new TodoDbHelper(context);
    }
    public void openDb(){
        database = dbHelper.getWritableDatabase();
    }
    public void closeDb(){
        database.close();
    }
    public void createRow(String mtitle, String msubtitle){
        ContentValues values = new ContentValues();
        values.put(TodoEntry.COLUMN_NAME_TITLE,mtitle);
        values.put(TodoEntry.COLUMN_NAME_SUBTITLE,msubtitle);
        database.insert(TodoEntry.TABLE_NAME,null,values);

    }
    public TodoNote readRow(){
        Cursor cursor =
                //database.rawQuery("select * from notes",null);
                database.query(TodoEntry.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToLast();//move to the last row of the queried result
        int titleIndex = cursor.getColumnIndexOrThrow(TodoEntry.COLUMN_NAME_TITLE);
        int subtitleIndex = cursor.getColumnIndexOrThrow(TodoEntry.COLUMN_NAME_SUBTITLE);

        String title = cursor.getString(titleIndex);
        String subtitle = cursor.getString(subtitleIndex);

        return new TodoNote(title,subtitle);
        //return title+"\n"+subtitle;
    }



    public void getTodoNote(TodoDataSource.GetTodoNote callback) {
        //open the db and query for the note and return the note
        TodoNote note = new TodoNote("mytitle","mysubtitle");
        callback.onNoteLoaded(note);//dd
        //TodoNote note = new TodoNote("mytitle","mysubtitle");
        callback.onNoteLoaded(readRow());//dd
    }
}
