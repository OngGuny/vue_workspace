package service;

import java.util.List;

import dto.MemberDTO;

public interface Memberservice {
	public abstract void joinMember(String id, String name, String email) throws Exception;
	public abstract List<MemberDTO> listMember() throws Exception; 
	public abstract MemberDTO viewMember(String id) throws Exception;
}
