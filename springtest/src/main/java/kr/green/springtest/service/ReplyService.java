package kr.green.springtest.service;

import java.util.ArrayList;

import kr.green.springtest.vo.ReplyVO;

public interface ReplyService {

	int insertReply(ReplyVO rvo);

	ArrayList<ReplyVO> getReplyList(int num);

}
