package com.test.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.test.app.services.ITreeService;

@RestController
@RequestMapping("/api/tree")
public class TreeController {

	@Autowired
	private ITreeService treeService;

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	public String addNode(@RequestBody int[] nodes) {
		return treeService.createTree(nodes);
	}

	@RequestMapping(value = "/{n1}/{n2}", method = RequestMethod.GET, produces = "application/json")
	public String findCommonFirstAncestor(@PathVariable(value = "n1") int n1, @PathVariable(value = "n2") int n2) {
		return treeService.findCommonFirstAncestor(n1, n2);
	}
}
