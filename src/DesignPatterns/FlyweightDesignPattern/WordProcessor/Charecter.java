package DesignPatterns.FlyweightDesignPattern.WordProcessor;

import DesignPatterns.FlyweightDesignPattern.WordProcessor.CharacterInterface;

public class Charecter implements CharacterInterface {


    private Character ch;
    private String font;

    private String size;


    public Charecter(String font, String size, Character ch){
        this.ch = ch;
        this.font = font;
        this.size = size;
    }

    @Override
    public void display(int x, int y) {

    }
}
