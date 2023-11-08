package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

@Setter(onMethod_ = @Autowired)
private BoardMapper mapper;

@Test
public void testList() {
	mapper.getList().forEach(board->{
		log.info(board);
	});
}

@Test
public void testInsert() {
	BoardVO board = new BoardVO();
	board.setTitle("새로 작성하는 글");
	board.setContent("새로 작성하는 내용");
	board.setWriter("min");
	
	mapper.insert(board);
	
	log.info(board);
}

@Test
public void testRead() {
	// exist number of post
	BoardVO b = mapper.read(2L);
	
	log.info(b);
}

@Test
public void testUpdate() {
	BoardVO b = new BoardVO();
	// 실행전 존재하는 번호인지 확인
	b.setId(13L);
	b.setTitle("수정된 제목");
	b.setContent("수정된 내용");
	b.setWriter("user00");
	
	int count = mapper.update(b);
	log.info("Update count: " + count);
}

@Test
public void delete() {
	log.info("DELETE COUNT : " + mapper.delete(2L));
}
}
