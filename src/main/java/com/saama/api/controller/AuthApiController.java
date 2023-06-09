package com.saama.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saama.model.PrivilegeData;
import com.saama.service.AuthServceImpl;

/**
 * @author Manju Veerarajan
 *
 */
@RestController
@RequestMapping("/roles")
public class AuthApiController {

	@Autowired
	AuthServceImpl authService;

	Logger logger = LoggerFactory.getLogger(AuthApiController.class);

	/**
	 * @param id
	 * @return Mapped privileges and roles of the given user
	 */
	@GetMapping("/{id}")
	public ResponseEntity<PrivilegeData> getById(@PathVariable Long id) {
		PrivilegeData privileges = authService.getPrivileges(id);
		if (privileges != null) {
			return new ResponseEntity<>(privileges, HttpStatus.ACCEPTED);
		}
		return null;
	}
}
