//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dictionary<String, String, Integer> myDictionary = new Dictionary<>();

        myDictionary.put("hello", "xin chao", 1);
        myDictionary.put("one", "so mot", 2);
        System.out.println(myDictionary.containKey("hello", "xin chao"));
        if(myDictionary.containKey("hello", "xin chao")){
            System.out.println(myDictionary.get("hello", "xin chao"));
        }
    }
}