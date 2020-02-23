package edu.weber;

public class BWCartridge implements ICartridge{

    @Override
    public String toString() {
        return "Black and white cartridge!";
    }

    @Override
    public String getFillPercentage() {
        return "Black and White 50%";
    }
}
