package com.example.myapplication.model;

import java.util.ArrayList;
import java.util.List;

public class MainModel {
    private List<Note> notes;

    public MainModel() {
        notes = new ArrayList<>();
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public boolean writeToDB(String note) {
        // Добавление в Базу данных
        //...
        return true;
    }
}
