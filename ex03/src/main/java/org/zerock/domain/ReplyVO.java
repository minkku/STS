package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private Long id;
	private Long tb1_board_id; 
	
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
}
