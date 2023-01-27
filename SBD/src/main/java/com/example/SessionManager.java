package com.example;



import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

class Pair<K, V> { ///////////////////////////////////Pewnie do wyjebania, ale zobaczymy

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey()    { return key; }
    public V getValue() { return value; }
}
@Component
public class SessionManager {
    private List<Pair<UUID, String>> sessions;

    public UUID createNewSession(String username){
        UUID newId = UUID.randomUUID();
        sessions.add(new Pair<UUID, String>(newId, username));
        return newId;
    }

    boolean closeSession(UUID sessionId, String username){
        return sessions.remove(new Pair<UUID, String>(sessionId, username));
    }
}
