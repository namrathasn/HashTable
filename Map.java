package com;

import java.util.ArrayList;


/**
 * Map class
 *
 * @param <K> key 
 * @param <V> value
 */

public class Map<K, V> {
	// it contains the chain
	public ArrayList<HashNode<K, V>> chainArray;
	// capacity of array list
	public int arrCapacity;
	// size of array list
	public int size;

	//constructor( initializing capacity, size and
	//empty chain
	public Map() {
		chainArray = new ArrayList<>();
		arrCapacity = 11;
		size = 0;

		for (int i = 0; i < arrCapacity; i++) {
			chainArray.add(null);
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int hashIndex(K key) {
		int hashCod = (int) key;
		return hashCod % 11;
	}

	/**
	 * The get function takes a key as an input and returns the corresponding value
	 * if key is present else it returns null
	 * 
	 * @param key takes a key to give value
	 * @return value , else @return null
	 */

	// Returns value corresponding to the key

	public V get(K key) {
		// Find head of chain for given key
		int hashIndex = hashIndex(key);
		HashNode<K, V> head = chainArray.get(hashIndex);

		// Search key in chain
		while (head != null) {
			if (head.key.equals(key))
				return head.value;
			head = head.next;
		}

		// If key not found
		return null;
	}

	/**
	 * add is an method of public void type
	 * add function for adding key and value
	 * If load factor goes beyond threshold, then
	 * double hash table size
	 * @param key
	 * @param value
	 */
	public void add(K key, V value) {
		int hashIndex = hashIndex(key);
		// Get head of chain
		HashNode<K, V> head = chainArray.get(hashIndex);
		// Check if key is already present
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		// Insert key in chain
		size++;
		head = chainArray.get(hashIndex);
		HashNode<K, V> newNode = new HashNode<K, V>(key, value);
		newNode.next = head;
		chainArray.set(hashIndex, newNode);
		// whenever we add a key-value pair to the Hash Table we check the load factor
		// if it is greater than 0.7 we double the size of our hash table.
		if ((1.0 * size) / arrCapacity >= 0.7) {
			ArrayList<HashNode<K, V>> temp = chainArray;
			chainArray = new ArrayList<>();
			arrCapacity = 2 * arrCapacity;
			size = 0;
			for (int i = 0; i < arrCapacity; i++)
				chainArray.add(null);

			for (HashNode<K, V> headNode : temp) {
				while (headNode != null) {
					add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}
	}

	/**
	 * remove is an method of public type remove method used for removing node from
	 * chain Here first we are fetching the index corresponding to the input key
	 * 
	 * @param key based on key we find value to remove
	 * @return
	 */

	public V remove(K key) {
		// Apply hash function to find index for given key
		int hashIndex = hashIndex(key);

		// Get head of chain
		HashNode<K, V> head = chainArray.get(hashIndex);

		// Search for key in its chain
		HashNode<K, V> prev = null;
		while (head != null) {
			// If Key found
			if (head.key.equals(key))
				break;

			// Else keep moving in chain
			prev = head;
			head = head.next;
		}

		// If key was not there
		if (head == null)
			return null;

		// Reduce size
		size--;

		// Remove key
		if (prev != null)
			prev.next = head.next;
		else
			chainArray.set(hashIndex, head.next);

		return head.value;
	}

	/**
	 * Display method is of public void type 
	 * display method used for displaying or
	 * to print the added key and value pair First will add the value for head then
	 * if head is not null will print next value
	 */

	public void display() {
		for (int i = 0; i < chainArray.size(); i++) {

			System.out.println("array index : " + i);
			HashNode<K, V> head = chainArray.get(i);
			while (head != null) {

				System.out.println(head.value);

				head = head.next;

			}

		}

	}

}
