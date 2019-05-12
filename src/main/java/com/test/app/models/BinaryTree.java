package com.test.app.models;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

	private Node root;

	public void addNode(int value) {
		root = addRecursive(root, value);
	}

	private Node addRecursive(Node current, int value) {
		if (current == null) {
			return new Node(value);
		}

		if (value < current.getValue()) {
			current.setLeft(addRecursive(current.getLeft(), value));
		} else if (value > current.getValue()) {
			current.setRight(addRecursive(current.getRight(), value));
		} else {
			return current;
		}
		return current;
	}

	public int findCommonFirstAncestor(int value1, int value2) {

		List<Integer> arr1 = new ArrayList<Integer>();
		List<Integer> arr2 = new ArrayList<Integer>();
		arr1 = containsNodeRecursiveList(root, value1, arr1);
		arr2 = containsNodeRecursiveList(root, value2, arr2);
		List<Integer> arrCommon = findCommonElements(arr1, arr2);
		int a = arrCommon.get(arrCommon.size() - 1);
		return a;
	}

	private List<Integer> containsNodeRecursiveList(Node current, int value, List<Integer> listo) {

		if (current == null) {
			return null;
		}

		listo.add(current.getValue());

		if (value == current.getValue()) {
			return listo;
		}
		return value < current.getValue() ? containsNodeRecursiveList(current.getLeft(), value, listo)
				: containsNodeRecursiveList(current.getRight(), value, listo);
	}

	private List<Integer> findCommonElements(List<Integer> arr1, List<Integer> arr2) {
		List<Integer> array = new ArrayList<Integer>();
		List<Integer> set = new ArrayList<Integer>();
		for (int ele : arr1) {
			set.add(ele);
		}
		for (int ele : arr2) {
			if (set.contains(ele)) {
				array.add(ele);
			}
		}
		return array;
	}

}