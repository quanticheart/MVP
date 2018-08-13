package com.master.killercode.mvp;

import android.content.ContentValues;
import android.content.Context;
import com.master.killercode.mvp.Helper.DataBaseUtil;
import com.master.killercode.mvp.Helper.SQLiteHelper;
import java.util.List;

final class mvpModel {

    private DataBaseUtil dbUtil;

    mvpModel(Context context) {
        dbUtil = new DataBaseUtil(context);
    }

    public void addJob(ContentValues data) {
        dbUtil.addJob(SQLiteHelper.TABLE_NAME, data);
    }

    public void deleteJob(final String field_params) {
       dbUtil.deleteJob(SQLiteHelper.TABLE_NAME, field_params);
    }

    public List<String> loadAllJobs() {
        return dbUtil.getList();
    }
}