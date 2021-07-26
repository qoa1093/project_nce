package kr.green.springtest.service;

import java.util.ArrayList;

import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.vo.ReplyVO;

public interface ReplyService {

	int insertReply(ReplyVO rvo);

	ArrayList<ReplyVO> getReplyList(int num, Criteria cri);

	int getTotalCount(int num);

	String updateReply(ReplyVO reply);

	String deleteReply(ReplyVO reply);

}
