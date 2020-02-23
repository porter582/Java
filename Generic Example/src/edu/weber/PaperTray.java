package edu.weber;

public class PaperTray {

    private int pages = 0;

    public void addPages(int count)
    {
        pages+=count;
    }

    public void usePage()
    {
        pages--;
    }

    public boolean isEmpty()
    {
        return pages <= 0;
    }
}
