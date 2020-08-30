package com.todo.detail.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String task;

    private boolean done;

    public Todo() {
    }

    public Todo(String task) {
        this.task = task;
    }

    public Todo(String task, boolean done) {
        this.task = task;
        this.done=done;
    }

    public void done() {
        this.done = true;
    }

    public void undone() {
        this.done = false;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public boolean isDone() {
        return done;
    }
}

