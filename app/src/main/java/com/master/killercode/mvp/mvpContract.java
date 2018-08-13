package com.master.killercode.mvp;

import java.util.List;

public interface mvpContract {

    // Responsavel pela tela
    interface View {
        void searshJobs();
        void showLog(String msg);
    }

    // Responsavel pela logica
    interface Presenter {
        void addJob(String text);
        void deleteJob(String text);
        List<String> getJobsList();
    }
}
