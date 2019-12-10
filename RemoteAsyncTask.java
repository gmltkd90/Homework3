package com.cpsc411.homework_2;

import android.os.AsyncTask;

public class RemoteAsyncTask extends AsyncTask<Void, Void, Void> {

    protected MainActivity activity;

    public RemoteAsyncTask(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        activity.testWebService_add();
        activity.testWebService();
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        //super.onPostExecute(aVoid);
        activity.refreshScreen();
    }
}
