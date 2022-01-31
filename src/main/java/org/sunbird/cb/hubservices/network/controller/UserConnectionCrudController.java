package org.sunbird.cb.hubservices.network.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sunbird.cb.hubservices.model.ConnectionRequest;
import org.sunbird.cb.hubservices.model.Response;
import org.sunbird.cb.hubservices.serviceimpl.ConnectionService;
import org.sunbird.cb.hubservices.util.Constants;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/connections")
public class UserConnectionCrudController {

	@Autowired
	private ConnectionService connectionService;

	@PostMapping("/add")
	public ResponseEntity<Response> add(@RequestHeader String rootOrg, @RequestBody ConnectionRequest request)
			throws IOException {
		request.setStatus(Constants.Status.APPROVED);
		request.setCreatedAt(new Date().toString());
		Response response = connectionService.upsert(request);
		return new ResponseEntity<>(response, (HttpStatus) response.get("status"));
	}

	@PostMapping("/update")
	public ResponseEntity<Response> update(@RequestHeader String rootOrg, @RequestBody ConnectionRequest request)
			throws IOException {
		String connectionId = request.getUserIdTo();
		String userId = request.getUserIdFrom();
		request.setUserIdFrom(connectionId);
		request.setUserIdTo(userId);
		request.setUpdatedAt(new Date().toString());
		Response response = connectionService.upsert(request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}