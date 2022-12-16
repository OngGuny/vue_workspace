package dao;

import java.util.List;

import dto.MemberDTO;
import service.Memberservice;

public interface MemberDAO extends Memberservice {
	public abstract void joinMember(String id, String name, String email) throws Exception;
	//아래 둘은 제이슨 파일로 돌려줘야함...?
	public abstract List<MemberDTO> listMember() throws Exception; 

	public abstract MemberDTO viewMember(String id) throws Exception;
}
