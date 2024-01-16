package assignment2;

/**
 *
 * This is a generic class representing a list of objects.
 * The operations on the list are as follows:
 * - adding and removing elements from the left and from the right.
 * - reversing the list
 * - obtaining the middle element
 * - getting the size of the list
 *
 * **All operations must run in O(1) time.**
 */

import java.util.NoSuchElementException;
//https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
/**
Arshia Hamedi
 30139967
 CMPT225
 Winter 23
 */

public class MyLinkedList<T> {

	/**
	 * The constructor creates an empty list
	 */
	private static class Node<T> { //https://www.w3schools.com/java/ref_keyword_private.asp
		private T data;
		private Node<T> next; //https://www.geeksforgeeks.org/access-modifiers-java/
		public Node(T data) {
			this.data = data;
		}
	}

	private Node<T> head;
	private Node<T> tail;
	private int size;

	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Adds the new item to the left of the list.
	 */
	public void addLeft(T item) {
//		if (head == null) {
//			head = tail = newNode;
//		} else {
//			newNode.next = head;
//			head = newNode;
		if (head == null)
		{ //checked if list is empty
			head = tail = new Node<>(item);
		}
		else
		{ //creating new node with given item
			Node<T> newNode = new Node<>(item);
			newNode.next = head;
			head = newNode;
			//setting next pointed of the new note to current node
		} //https://www.javatpoint.com/java-program-to-create-a-singly-linked-list-of-n-nodes-and-count-the-number-of-nodes
		size++;
		//kept track of number of nodes in the list
	}
	/**
	 * Adds the new item to the right of the list.
	 */
	public void addRight(T item) {
		Node<T> newNode = new Node<>(item);
		//taking in item of type T
		//creating a new node for item of type T
		if (tail != null)
		{
			tail.next = newNode;
		}
		tail = newNode; //https://www.geeksforgeeks.org/adding-an-element-to-the-front-of-linkedlist-in-java/
		if (head == null)
		{
			head = newNode;
		}
		size++;
	}

	/**
	 * Removes the leftmost item from the list and returns it.
	 * If the list is empty, throws NoSuchElementException.
	 */
	public T removeLeft() { //https://stackoverflow.com/questions/1857590/remove-element-from-linked-list-java
		if (head == null)
		{
			throw new NoSuchElementException();
		}
		T item = head.data;
		if (head == tail)
		{
			head = tail = null;
		}
		else
		{
			head = head.next;
		}
		size--;
		return item;
	}


	/**
	 * Removes the rightmost item from the list and returns it.
	 * If the list is empty, throws NoSuchElementException.
	 */
	public T removeRight() {
		if (head == null)
		{
			throw new NoSuchElementException();
		}
		T item = tail.data;
		if (head == tail) {
			head = tail = null;
		}
		else
		{
			Node<T> current = head;
//			current = current.next;
//			while (current.next != null) {
//				current = current.next;
//			}
//			tail = current;
//			current.next = null;
//			size--;
//			return item;
			while (current.next.next != null)
			{
				current = current.next;
			}
			current.next = null;
			tail = current;
		}
		size--;
		return item;
	}

	/**
	 * Reverses the list
	 */
	public void reverse() { //https://www.studytonight.com/java-programs/how-to-reverse-a-linked-list-in-java
		Node<T> current = head;
		Node<T> next = null;
		Node<T> prev = null;
		tail = head;
		while (current != null)
		{ //https://www.baeldung.com/java-reverse-linked-list
			next = current.next;
			current.next = prev;
			prev = current; //reversing direction of the links between nodes
//			current = current.next;
//			next.next = prev;
//			prev = prev.next;
			current = next;
		}
		head = prev; //first  node of the list becomes the last node of reversed
	}

	/**
	 * Returns the item in the middle of the list.
	 * If the list is empty, throws NoSuchElementException.
	 */
	public T getMiddle() { //https://www.enjoyalgorithms.com/blog/find-middle-of-linked-list
		if (head == null)
		{ //checked if list is empty

			throw new NoSuchElementException();
		}
		Node<T> slow = head; //https://leetcode.com/problems/middle-of-the-linked-list/
		Node<T> fast = head;
		while (fast != null && fast.next != null)
		{ //slow pointer moves one step at a time
			//fast pointer moves two step at a time
			slow = slow.next;
			fast = fast.next.next;
		} //when fast pointer is at the end, slow is at the middle
		return slow.data; //where slow pointer has stopped
	}

	/**
	 * Returns the size of the list.
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns true if list is empty, and returns false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}
}