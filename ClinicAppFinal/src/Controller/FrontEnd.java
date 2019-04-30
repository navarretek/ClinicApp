package Controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import Model.Node;
import Model.Patient;

public class FrontEnd {
	Queue<Node> patientQ = new PriorityQueue<>(priorityComparator);
	
	
	public void addToQ(Patient patient,int priority) {
		Node checkedIn = new Node(patient,priority);
		patientQ.add(checkedIn);
	}
	
	public List<Node> getQList(){
		List<Node> list = new ArrayList<>();
		Object[] alist = patientQ.toArray();
		
		for (int i = 0; i < alist.length; i++) {
			list.add((Node) alist[i]);
		}
		return list;
	}
	public void dequeue() {
		patientQ.remove();
	}
	
	
	
	public static Comparator<Node> priorityComparator = new Comparator<Node>() {
		@Override
		public int compare(Node n1, Node n2) {
			return (n1.getPriority() - n2.getPriority());
		}
	};
}
