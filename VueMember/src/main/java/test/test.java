package test;

import dao.impl.MemberDAOImpl;
import service.Memberservice;

public class test {
public static void main(String[] args) {
	MemberDAOImpl ms = new MemberDAOImpl();
	try {
		ms.joinMember();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
