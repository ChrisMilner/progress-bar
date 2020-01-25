package com.chrisdmilner.progressbar.style;

public class ProgressBarStyle {
    public final int width;
    public final String title;
    public final String label;
    public final String start;
    public final String end;
    public final char completed;
    public final char uncompleted;
    public final char head;
    public final String doneMessage;

    ProgressBarStyle(
            int width,
            String title,
            String label,
            String start,
            String end,
            char completed,
            char uncompleted,
            char head,
            String doneMessage) {
        this.width = width;
        this.title = title;
        this.label = label;
        this.start = start;
        this.end = end;
        this.completed = completed;
        this.uncompleted = uncompleted;
        this.head = head;
        this.doneMessage = doneMessage;
    }
}
