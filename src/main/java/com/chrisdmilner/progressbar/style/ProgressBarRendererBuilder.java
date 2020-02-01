package com.chrisdmilner.progressbar.style;

public class ProgressBarRendererBuilder {

    private int width = 20;
    private String title = "";
    private String label = "";
    private String start = "|";
    private String end = "|";
    private char completed = '=';
    private char uncompleted = ' ';
    private char head = '>';
    private String doneMessage = "Done!";

    public ProgressBarRendererBuilder() {}

    public ProgressBarRendererBuilder withWidth(int width) {
        this.width = width;
        return this;
    }

    public ProgressBarRendererBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public ProgressBarRendererBuilder withLabel(String label) {
        this.label = label;
        return this;
    }

    public ProgressBarRendererBuilder withStart(String start) {
        this.start = start;
        return this;
    }

    public ProgressBarRendererBuilder withEnd(String end) {
        this.end = end;
        return this;
    }

    public ProgressBarRendererBuilder withCompleted(String completed) {
        this.completed = completed.charAt(0);
        return this;
    }

    public ProgressBarRendererBuilder withUncompleted(String uncompleted) {
        this.uncompleted = uncompleted.charAt(0);
        return this;
    }

    public ProgressBarRendererBuilder withHead(String head) {
        this.head = head.charAt(0);
        return this;
    }

    public ProgressBarRendererBuilder withDoneMessage(String doneMessage) {
        this.doneMessage = doneMessage;
        return this;
    }

    public ProgressBarRenderer build() {
        return new ProgressBarRenderer(
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
