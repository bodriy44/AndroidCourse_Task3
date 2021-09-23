package com.example.myapplication.presenter;


import com.example.myapplication.R;
import com.example.myapplication.model.MainModel;
import com.example.myapplication.view.MainActivity;
import com.example.myapplication.view.ViewInterface;

public class MainPresenter {
    private ViewInterface view;
    private final MainModel model;

    public MainPresenter(ViewInterface view) {
        this.view = view;
        this.model = new MainModel();
    }

    public void addNote() {

        String data = view.getNoteText();
        if (model.writeToDB(data)) {
            view.showSaveNotify("Заметка сохранена");
        } else {
            view.showSaveNotify("Ошибка сохранения");
        }
    }

}
