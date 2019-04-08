package com.github.rogerp91.tasks_communication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.github.rogerp91.tasks_communication.data.AgeDto;
import com.github.rogerp91.tasks_communication.data.NamesDataSource;
import com.github.rogerp91.tasks_communication.domain.GetAge;
import com.github.rogerp91.tasks_communication.domain.GetNames;
import com.github.rogerp91.tasks_communication.domain.GetNamesForCountry;
import com.github.rogerp91.tasks_communication.presentation.NamesContract;
import com.github.rogerp91.tasks_communication.presentation.NamesPresenter;
import com.github.rogerp91.tasks_communication.util.DisposableManager;
import com.github.rogerp91.tasks_communication.util.SchedulerProvider;
import com.github.rogerp91.tasks_communication.view.NamesModel;

import java.util.List;

import io.reactivex.schedulers.Schedulers;

public class NamesActivity extends AppCompatActivity implements NamesContract.View {

    private NamesPresenter namesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            init(bundle);
        } else {
            finish();
        }
    }

    private void init(Bundle bundle) {
        NamesDataSource tasksDataSource = bundle.getParcelable("DataSource");
        GetNames getNames = new GetNames(tasksDataSource, SchedulerProvider.getInstance());
        GetAge getAge = new GetAge(tasksDataSource, SchedulerProvider.getInstance());
        GetNamesForCountry getNamesForCountry = new GetNamesForCountry(tasksDataSource, SchedulerProvider.getInstance());
        namesPresenter = new NamesPresenter(this, getNames, getAge, getNamesForCountry);
        namesPresenter.loadTasks();
    }

    @Override
    public void showAge(List<AgeDto> ageDtos) {
        for (AgeDto ageDto : ageDtos) {
            Log.d("AGE", String.valueOf(ageDto.getAge()));
        }
    }

    public void getAge(View view) {
        namesPresenter.loadCountry();
    }

    @Override
    protected void onDestroy() {
        DisposableManager.clear();
        super.onDestroy();
        namesPresenter = null;
    }

    @Override
    public void showTasks(List<NamesModel> namesModels) {
        for (NamesModel namesModel : namesModels) {
            Log.d("NAMES", namesModel.getName() + ",pais: " + namesModel.getRegion());
        }
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
    }
}
