package com.test.app.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.app.services.ITreeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TreeServiceImpl {

	@Autowired
	private ITreeService treeService;

	@Test
	public void createTreeTest() {

		int[] nodes = { 70, 49, 84, 37, 54, 78, 85, 22, 40, 51, 76, 80 };
		String response = treeService.createTree(nodes);
		assertEquals("Se ha creado el arbol exitosamente", response);
	}
	
	@Test
	public void failCreateTreeTest() {

		int[] nodes = null;
		String response = treeService.createTree(nodes);
		assertEquals("Algo ha salido mal", response);
	}
	
	@Test
	public void findCommonFirstAncestorTest() {
		int[] nodes = { 70, 49, 84, 37, 54, 78, 85, 22, 40, 51, 76, 80 };
		treeService.createTree(nodes);
		String response = treeService.findCommonFirstAncestor(22, 76);
		assertEquals("70", response);
	}
	
	@Test
	public void failFindCommonFirstAncestorTest() {
		int[] nodes = { 70, 49, 84, 37, 54, 78, 85, 22, 40, 51, 76, 80 };
		treeService.createTree(nodes);
		String response = treeService.findCommonFirstAncestor(1, 2);
		assertEquals("Algo ha salido mal", response);
	}
}
