package edu.weber;

public class PaperTray {

    private int numberPages = 0;

    public void addPaper(int count)
    {
        numberPages += count;
    }

    public boolean isEmpty()
    {
        return numberPages <= 0;
    }

    public void usePage()
    {
        numberPages--;
    }
}
