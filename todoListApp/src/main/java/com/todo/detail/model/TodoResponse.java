package com.todo.detail.model;

public class TodoResponse {
    private final int id;
    private final String task;
    private final boolean done;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.task = todo.getTask();
        this.done = todo.isDone();
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

    @Override
    public String toString() {
        return "TodoResponse{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", done=" + done +
                '}';
    }
}
