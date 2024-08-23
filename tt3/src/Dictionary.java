import java.util.HashMap;

public class Dictionary <K1, K2, V>{
    private HashMap<K1, HashMap<K2, V>> map;

    public Dictionary(){
        map = new HashMap<K1, HashMap<K2, V>>();
    }
    public V get (K1 key1,K2 key2){
        HashMap<K2, V> hashMap = map.get(key1);
        return hashMap.get(key2);
    }
    public void put (K1 key1, K2 key2, V vaule){
        if(containKey(key1, key2) == false){
            HashMap<K2, V> hashMap = new HashMap<K2, V>();
            hashMap.put(key2, vaule);
            map.put(key1, hashMap);
        }
    }
    boolean containKey(K1 key1, K2 key2){
        boolean check = false;
        if(map.get(key1) != null){
            HashMap<K2, V> hashMap = map.get(key1);
            if (hashMap.get(key2) != null){
                check = true;
            }
        }
        return check;
    }
}
