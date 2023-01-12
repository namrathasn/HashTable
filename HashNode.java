package com;

/**
 * HashNode Class,A node of chains
 *
 * @param <K> key
 * @param <V> value
 */

public class HashNode<K, V> {
	K key;
	V value;
	HashNode<K, V> next;

	HashNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
}
