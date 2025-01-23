package com.pp.ChallengeApp;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/challenges")
@CrossOrigin("http://localhost:5173")
public class ChallengeController {
	
	@Autowired
	private ChallengeService challengeService;
	
	public ChallengeController(ChallengeService challengeService) {
		this.challengeService = challengeService;
	}
	
	@GetMapping	
	public ResponseEntity<List<Challenge>> getAllChallenges(){
		return new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> addChallenges(@RequestBody Challenge challenge) {
		boolean isChallengeAdded = challengeService.addChallenges(challenge);
		
		if(isChallengeAdded) 
			return new ResponseEntity<>("Challenge added Successfully", HttpStatus.OK);
		else 
			return new ResponseEntity<>("Challenge not added Successfully", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{month}")
	public ResponseEntity<Challenge> getChallenge(@PathVariable String month) {
		
		Challenge challenge = challengeService.getChallenge(month);
		
		if(challenge !=null) return new ResponseEntity<>(challenge, HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updatedchallenge){
		boolean isChallengeUpdated = challengeService.updateChallenge(id, updatedchallenge);
		
		if(isChallengeUpdated) return new ResponseEntity<>("Challenge updated Successfully", HttpStatus.OK);
		else return new ResponseEntity<>("Challenge not updated Successfully", HttpStatus.NOT_FOUND); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
		
		boolean isDeleted = challengeService.deleteChallenge(id);
		if(isDeleted) return new ResponseEntity<>("Challenge deleted Successfully", HttpStatus.OK);
		else return new ResponseEntity<>("Challenge not deleted Successfully", HttpStatus.NOT_FOUND); 
	
		
	}

}
