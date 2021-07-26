package kr.green.springtest.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.springtest.pagination.Criteria;
import kr.green.springtest.vo.ReplyVO;

public interface ReplyDAO {

	void insertReply(@Param("rvo") ReplyVO rvo);// 파람을 안쓰면 rvo.~로 안써도 되지만 헷갈릴까봐 사용

	ArrayList<ReplyVO> getReplyList(@Param("num")int num, @Param("cri")Criteria cri);

	int getTotalCount(@Param("num")int num);

	ReplyVO getReply(@Param("rp_num")int rp_num);

	int updateReply(@Param("reply")ReplyVO dbReply); // 이 파람 이름으로 맵퍼에서 사용함

	

	

}
