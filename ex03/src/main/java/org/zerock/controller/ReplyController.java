package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies/")
@RestController
@Log4j
@AllArgsConstructor
public class ReplyController {
	private ReplyService sv;

	@PostMapping(value = "/new",
			consumes = "application/json",
			produces = { MediaType.TEXT_PLAIN_VALUE })		
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
			log.info("ReplyVO: " + vo);
			
			int insertCount = sv.resgister(vo);
			
			log.info("Reply INSERT COUNT: " + insertCount);
			
			return insertCount == 1
				? new ResponseEntity<>("sucess", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/pages/{id}/{page}", produces = {
			MediaType.APPLICATION_ATOM_XML_VALUE,
			MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE })
	public ResponseEntity<List<ReplyVO>> getList(
			@PathVariable("page") int page,
			@PathVariable("id") Long id) {
				log.info("getList...........");
				Criteria cri = new Criteria(page,10);
				return new ResponseEntity<>(sv.getList(cri, id), HttpStatus.OK);
			}
	
	// ���̵� ������ ��� ��ȸ
	@GetMapping(value = "/{id}",
			produces = {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("id") Long id) {
		log.info("get: " + id);
		
		return new ResponseEntity<>(sv.get(id), HttpStatus.OK);
	}
	
	// ���̵����� ��� ����
	@DeleteMapping(value = "/{id}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("id") int id) {
		log.info("remove :" + id);
		
		return sv.remove(id) == 1
			? new ResponseEntity<>("sucess", HttpStatus.OK)
			: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}
	
	//��� ����
	@RequestMapping(method = { RequestMethod.PATCH }, 
			value = "/{id}",
			consumes = "application/json",
			produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(
				@RequestBody ReplyVO vo,
				@PathVariable("id") Long id) {
		vo.setId(id);
		
		log.info("id :" + id);
		
		return sv.modify(vo) == 1
				? new ResponseEntity<>("sucess", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
	}
}
