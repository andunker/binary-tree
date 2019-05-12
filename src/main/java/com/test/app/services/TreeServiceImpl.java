package com.test.app.services;

import org.springframework.stereotype.Service;
import com.test.app.models.BinaryTree;

@Service
public class TreeServiceImpl implements ITreeService {

	private BinaryTree bt = new BinaryTree();

	@Override
	public String createTree(int[] nodes) {
		try {
			bt = new BinaryTree();
			for (int node : nodes) {
				bt.addNode(node);
			}
			return "Se ha creado el arbol exitosamente";
		} catch (Exception e) {
			return "Algo ha salido mal";
		}
	}

	@Override
	public String findCommonFirstAncestor(int value1, int value2) {
		try {
			return Integer.toString(bt.findCommonFirstAncestor(value1, value2));
		} catch (Exception e) {
			return "Algo ha salido mal";
		}
	}
}
