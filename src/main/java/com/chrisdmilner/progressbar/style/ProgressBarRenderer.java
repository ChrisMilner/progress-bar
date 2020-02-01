package com.chrisdmilner.progressbar.style;

public class ProgressBarRenderer {
    private final int width;
    private final String title;
    private final String label;
    private final String start;
    private final String end;
    private final char completed;
    private final char uncompleted;
    private final char head;
    private final String doneMessage;

    private int progress;

    ProgressBarRenderer(
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

        this.progress = -1;
    }

    public void init() {
        if (!title.isBlank()) {
            System.out.println(title);
        }
        update(0);
    }

    public void update(double proportion) {
        int next_progress = (int) (proportion * width);

        if (next_progress != progress) {
            progress = next_progress;

            System.out.print(label + " " + start);
            for (int i = 0; i < width; i++) {
                if (i < progress) {
                    System.out.print(completed);
                } else if (i < progress + 1) {
                    System.out.print(head);
                } else {
                    System.out.print(uncompleted);
                }
            }
            System.out.print(end);

            if (proportion >= 1) {
                System.out.println(" " + doneMessage);
            } else {
                System.out.print("\r");
            }
        }
    }

    public void finish() {
        update(1);
    }
}
