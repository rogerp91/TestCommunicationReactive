package com.github.rogerp91.tasks_communication.presentation;

import com.github.rogerp91.tasks_communication.data.AgeDto;
import com.github.rogerp91.tasks_communication.view.NamesModel;

import java.util.List;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public class NamesContract {

    public interface View {

        void showTasks(List<NamesModel> namesModels);

        void showError();

        void showAge(List<AgeDto> ageDtos);
    }

    public interface Presenter {

        void loadTasks();

        void loadCountry();

        void loadAge();

    }
}
