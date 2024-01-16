package assignment2;
import basicdatastructures.queue.*;
import basicdatastructures.queue.*;
import java.util.LinkedList;
import java.util.Stack;
//https://www.includehelp.com/java-programs/compare-two-queues.aspx
public class MyQueueOperations {
	/**
	 * Returns the number of elements in q.
	 */
	//https://www.techiedelight.com/clone-method-in-java/
	public static <T> int size(Queue<T> q) {
		//Takes a queue "q"
		int count = 0;
		Queue<T> temp = new QueueLinkedListBased<T>();

        //while (q.isEmpty())
		while (!q.isEmpty())
		{
			//count--;
			count++; //https://www.techiedelight.com/iterate-through-queue-java/
			temp.enqueue(q.dequeue());

		} //using temp queue to iterate thru elements of q and count them
		while (!temp.isEmpty())
		{
			q.enqueue(temp.dequeue());
		} //https://stackoverflow.com/questions/16893530/iterate-through-queue-of-objects-in-order

		return count; //number of elements in q
	}

	/**
	 * Returns a copy of orig. The items are copied from orig to the new queue using
	 * = operator. For the concrete type of the returned object, you may use either
	 * QueueArrayBased or QueueLinkedListBased, up to you.
	 */
	public static <T> Queue<T> clone(Queue<T> orig) {
		//https://www.geeksforgeeks.org/clone-method-in-java-2/
		Queue<T> newQueue = new QueueLinkedListBased<T>();
		Queue<T> temp = new QueueLinkedListBased<T>();
		//creating two new queues
		//Not sure why my code says "1 related problem" while it runs fine..

		//while (orig.isEmpty())
		while (!orig.isEmpty())
		{
			//https://stackoverflow.com/questions/22982157/how-do-i-copy-or-clone-a-linkedlist-implemented-queue-in-java
			T item = orig.dequeue();
			temp.enqueue(item); //elements of orig q are dequeued and put in a temp q
			newQueue.enqueue(item); //elements copy into a new queue
		}


		while (!temp.isEmpty())
		{
			orig.enqueue(temp.dequeue());
		}
		return newQueue;
	}
//	public static <T> Queue<T> clone(Queue<T> orig) {
//		Queue<T> newQueue = new QueueLinkedListBased<>();
//		while (!orig.isEmpty()) {
//			T item = orig.dequeue();
//			newQueue.enqueue(item);
//			orig.enqueue(item);
//		}
//		return newQueue;
//	}
	/**
	 * Reverses the order of the elements in q.
	 */
	public static <T> void reverse(Queue<T> q) {
		//https://www.geeksforgeeks.org/reversing-a-queue/
		//https://stackoverflow.com/questions/16857276/reverse-method-reverses-elements-of-a-queue
		Stack<T> stack = new Stack<T>(); //temp storing elements of q as they're being dequeued
		while (!q.isEmpty())
		{
			stack.push(q.dequeue());
		}
		//https://www.geeksforgeeks.org/clone-method-in-java-2/

		while (!stack.isEmpty())
		{
			q.enqueue(stack.pop()); //elements popped from stack and put backinto q
		}
	}

	/**
	 * Checks if the two queues have the same items in the same order. The items in
	 * the queues are compared using == operator.
	 */
	public static <T> boolean areEqual(Queue<T> q1, Queue<T> q2) {
		//https://codingdiksha.com/java-program-to-compare-two-queues/
		//https://www.includehelp.com/java-programs/compare-two-queues.aspx
		if (size(q1) != size(q2)) {
			return false; //if queues aren't even the same size to begin with
		} //https://stackoverflow.com/questions/42288752/comparing-queue-objects-in-java
		//		Queue<T> temp1 = clone(q1);
//		Queue<T> temp2 = clone(q2); //cloning both queues into temps
//		while (!temp1.isEmpty()) {
//			if (temp1.dequeue() != temp2.dequeue()) {
//				return false; //comparing dequeued elements from both q's
//			}
//		}
//		return true;
		Queue<T> temp1 = clone(q1);
		Queue<T> temp2 = clone(q2);


		while (!temp1.isEmpty())
		{
			T item1 = temp1.dequeue();
			T item2 = temp2.dequeue();

			if (!item1.equals(item2))
			{
				return false;
			}
		}
		return true;
	}
}