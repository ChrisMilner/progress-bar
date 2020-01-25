package com.chrisdmilner.progressbar.style;

public class ProgressBarStyleBuilder {

    private int width = 20;
    private String title = "";
    private String label = "";
    private String start = "|";
    private String end = "|";
    private char completed = '=';
    private char uncompleted = ' ';
    private char head = '>';
    private String doneMessage = "Done!";

    public ProgressBarStyleBuilder() {}

    public ProgressBarStyleBuilder withWidth(int width) {
        this.width = width;
        return this;
    }

    public ProgressBarStyleBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ProgressBarStyleBuilder withLabel(String label) {
        this.label = label;
        return this;
    }

    public ProgressBarStyleBuilder withStart(String start) {
        this.start = start;
        return this;
    }

    public ProgressBarStyleBuilder withEnd(String end) {
        this.end = end;
        return this;
    }

    public ProgressBarStyleBuilder withCompleted(String completed) {
        this.completed = completed.charAt(0);
        return this;
    }

    public ProgressBarStyleBuilder withUncompleted(String uncompleted) {
        this.uncompleted = uncompleted.charAt(0);
        return this;
    }

    public ProgressBarStyleBuilder withHead(String head) {
        this.head = head.charAt(0);
        return this;
    }

    public ProgressBarStyleBuilder withDoneMessage(String doneMessage) {
        this.doneMessage = doneMessage;
        return this;
    }

    public ProgressBarStyle build() {
        return new ProgressBarStyle(
                width,
                title,
                label,
                start,
                end,
                completed,
                uncompleted,
                head,
                doneMessage);
    }
}
