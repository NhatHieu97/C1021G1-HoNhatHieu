package controller;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    public Map<String,String> mapDictionary(){
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("dog", "chó");
        dictionary.put("cat", "mèo");
        dictionary.put("bike", "xe dạp");
        dictionary.put("Math","môn toán");
        return dictionary;
    }
}
