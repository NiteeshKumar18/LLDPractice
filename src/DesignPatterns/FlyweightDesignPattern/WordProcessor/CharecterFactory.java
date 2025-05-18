package DesignPatterns.FlyweightDesignPattern.WordProcessor;

import DesignPatterns.FlyweightDesignPattern.WordProcessor.CharacterInterface;
import DesignPatterns.FlyweightDesignPattern.WordProcessor.Charecter;

import java.util.HashMap;
import java.util.Map;

public class CharecterFactory {

    private Map<Character, CharacterInterface> characterInterfaceMap = new HashMap<>();


    public CharacterInterface buildCharecter(Character ch) {
        if (characterInterfaceMap.containsKey(ch)) {
            return characterInterfaceMap.get(ch);
        } else {
            CharacterInterface characterInterface = new Charecter("Arial", "10", ch);
            characterInterfaceMap.put(ch, characterInterface);
            return characterInterface;
        }
    }
}
