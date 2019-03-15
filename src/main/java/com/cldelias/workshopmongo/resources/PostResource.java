package com.cldelias.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cldelias.workshopmongo.domain.Post;
import com.cldelias.workshopmongo.resources.util.URL;
import com.cldelias.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = this.postService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping(value = "/titlesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitl(@RequestParam(value="text", defaultValue="") String text) {
		List<Post> list = this.postService.findByTitle(URL.decodeParam(text));
		return ResponseEntity.ok().body(list);
	}

}