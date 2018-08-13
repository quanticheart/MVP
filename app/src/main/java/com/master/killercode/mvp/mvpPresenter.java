package com.master.killercode.mvp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;

import com.master.killercode.mvp.Helper.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class mvpPresenter implements mvpContract.Presenter {
    private mvpModel model;
    private List<String> jobList;

    private mvpContract.View mView;

    mvpPresenter(Context context, mvpContract.View view) {
        jobList = new ArrayList<>();
        model = new mvpModel(context);
        mView = view;
    }
    
    @Override
    public void addJob(final String title) {
        final ContentValues data = new ContentValues();
        data.put(SQLiteHelper.COLLUM, title);
        model.addJob(data);
        mView.showLog("btn new job Added");
    }

    @Override
    public void deleteJob(final String title) {
        model.deleteJob(title);
    }

//    public void deleteJob(final long id) {
//        model.deleteJob("id='" + id + "'");
//    }
//
//    public void deleteAllJob() {
//        model.deleteJob(null);
//    }

    @SuppressLint("DefaultLocale")
    @Override
    public List<String> getJobsList() {
        jobList.clear();
        jobList = model.loadAllJobs();
        mView.showLog(String.format("%d Jobs Found ", jobList.size()));
        return jobList;
    }
}
