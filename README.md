class MyLinkedList. This is a generic class representing a list
of objects. The operations on the list are as follows:
- adding and removing elements from the left and from the right.
- reversing the list
- obtaining the middle element
- getting the size of the list
All operations run in O(1) time (not tested!)
  constructors and operations:
public MyLinkedList()
Creates an empty linked list
public void addLeft(T item)
Adds the new item to the left of the list.
public void addRight(T item)
Adds the new item to the right of the list.
public T removeLeft()
Removes the leftmost item from the list and returns it.
If the list is empty, throws NoSuchElementException.
public T removeRight()
Removes the rightmost item from the list and returns it.
If the list is empty, throws NoSuchElementException.
public void reverse()
Reverses the list.
For example, if the list was 1-2-3-1-4, after running the method, it becomes 4-1-3-2-1.
public T getMiddle()
Returns the item in the middle of the list.
If the list has even length (and there are two middle nodes) the method
returns the node closer to the right end.
For example:

if the list is 3-4-5-6-5-4-3, the method returns 6.

if the list is 100, the method returns 100.

if the list is 0-6-8-100, the method returns 8.

if the list is 1-2, the method returns 2.

If the list is empty, throws NoSuchElementException.
public int size()
Returns the size of the list
public boolean isEmpty()
Checks if the list is empty

class MyQueueOperations<T>
The interface Queue<T> declares the standard operations: enqueue(), dequeue(), isEmpty().
Two concrete implementations: QueueArrayBased.java and QueueLinkedListBased.java
Public statics:
methods manipulating Queue. The public methods are as follows.
public static <T> int size(Queue<T> q)
Returns the number of elements in q.
public static <T> Queue<T> clone(Queue<T> orig)
Returns a copy of orig. The items are copied from orig to the new queue using = operator.
public static <T> void reverse(Queue<T> q)
Reverses the order of the elements in q.
public static <T> boolean areEqual(Queue<T> q1, Queue<T> q2)
Checks if the two queues have the same items in the same order.
The items in the queues are to be compared using == operator.
After the methods return, the input queues is in the same state as in the beginning
