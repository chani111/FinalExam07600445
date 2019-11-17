package com.example.finalexam07600445;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import java.util.List;

public class RegisterREpository {

    private Context mContext;

    public RegisterREpository(Context mContext) {
        this.mContext = mContext;
    }

    public void getLedger(Callback callback) {
        GetTask getTask = new GetTask(mContext, callback);
        getTask.execute();
    }

    public void insertLedger( regisitem item, InsertCallback callback) {
        InsertTask insertTask = new InsertTask(mContext, callback);
        insertTask.execute(item);
    }

    private static class GetTask extends AsyncTask<Void, Void, List<regisitem>> {

        private Context mContext;
        private Callback mCallback;

        public GetTask(Context context, Callback callback) {
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override
        protected List<regisitem> doInBackground(Void... voids) {
            appdatabase db = appdatabase.getInstance(mContext);
            List<regisitem> itemList = db.placeDao().getAll();
            return itemList;
        }

        @Override
        protected void onPostExecute(List<regisitem> ledgerItemList) {
            super.onPostExecute(ledgerItemList);

            mCallback.onGetLedger(ledgerItemList);
        }
    }   public interface Callback {
        void onGetLedger(List<regisitem> itemList);
    }

    private static class InsertTask extends AsyncTask<regisitem, Void, Void> {

        private Context mContext;
        private InsertCallback mCallback;

        public InsertTask(Context context, InsertCallback callback) {
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override
        protected Void doInBackground(regisitem... ledgerItems) {
            appdatabase db = appdatabase.getInstance(mContext);
            db.placeDao().insert(regisitem[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mCallback.onInsertSuccess();
        }
    } // ปิด InsertTask

    public interface InsertCallback {
        void onInsertSuccess();
    }
}