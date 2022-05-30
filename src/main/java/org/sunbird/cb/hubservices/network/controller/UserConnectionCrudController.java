package org.sunbird.cb.hubservices.network.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sunbird.cb.hubservices.model.ConnectionRequest;
import org.sunbird.cb.hubservices.model.Response;
import org.sunbird.cb.hubservices.serviceimpl.ConnectionService;
import org.sunbird.cb.hubservices.util.Constants;

@RestController
@RequestMapping(Constants.CONNECTIONS)
public class UserConnectionCrudController {

	@Autowired
	private ConnectionService connectionService;

	@PostMapping(Constants.ADD)
	public ResponseEntity<Response> add(@RequestHeader String rootOrg, @RequestBody ConnectionRequest request)
			throws Exception {
		Response response = connectionService.add(rootOrg, request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}

	@PostMapping(Constants.UPDATE)
	public ResponseEntity<Response> update(@RequestHeader String rootOrg, @RequestBody ConnectionRequest request)
			throws Exception {
		Response response = connectionService.update(rootOrg, request);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
