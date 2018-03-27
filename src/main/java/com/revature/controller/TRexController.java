package com.revature.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Message;
import com.revature.beans.Sender;
import com.revature.beans.TRex;

@RestController
@RequestMapping(value="/trex")
@CrossOrigin(origins = "http://localhost:4200")
public class TRexController {
	
	@Autowired
	private Sender s;
	
	@PostMapping("/addTRex")
	public ResponseEntity<Message> addTRex(@RequestBody TRex tRex) {

		ResponseEntity<Message> resp = null;
		try {
			s.sendTrex(tRex);
			resp = new ResponseEntity<>(new Message("T-REX CREATED SUCCESSFULLY"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			resp = new ResponseEntity<>(new Message("FAILED TO CREATE T-REX"), HttpStatus.BAD_REQUEST);
		}
		return resp;

	}

}
