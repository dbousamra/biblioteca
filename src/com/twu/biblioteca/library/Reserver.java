package com.twu.biblioteca.library;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Reserver<K, V> {

    private final Map<K, V> contents = new HashMap<K, V>();

    public V getItem(K key) {
        return contents.get(key);
    }

    public Collection<V> getAllItems() {
        return Collections.unmodifiableCollection(contents.values());
    }

    public void addItem(K key, V item) {
        contents.put(key, item);
    }

    public int getItemCount() {
        return contents.size();
    }
}