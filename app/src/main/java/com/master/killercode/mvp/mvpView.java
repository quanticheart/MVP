package com.master.killercode.mvp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

@SuppressLint("Registered")
public class mvpView extends AppCompatActivity implements mvpContract.View {
    public static final String APP_TAG = "John.mvp";

    private ListView lvJob;
    private EditText etnewJob;
    private Button btnAddJob;
    private mvpContract.Presenter presenter;


    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);

        initVars();
        initActions();

    }

    private void initVars() {
        presenter = new mvpPresenter(this, this);

        lvJob = findViewById(R.id.lvJob);
        btnAddJob = findViewById(R.id.btnAddJob);
        etnewJob = findViewById(R.id.etnewJob);
    }

    private void initActions() {
        btnAddJob.setOnClickListener(eventClickForNewJob);
        searshJobs();
    }


    private final View.OnClickListener eventClickForNewJob = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            presenter.addJob(etnewJob.getText().toString().trim());
            searshJobs();
        }
    };

    @Override
    public void searshJobs() {
        final List<String> jobsList = presenter.getJobsList();

        this.lvJob.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, jobsList.toArray(new String[]{})));

        this.lvJob.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
                showLog(String.format("Job id: %d at position: %d ", id, position));

                final TextView v = (TextView) view;

                presenter.deleteJob(v.getText().toString().trim());
                searshJobs();
            }
        });
    }

    @Override
    public void showLog(String msg) {
        Log.w(APP_TAG, msg);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}