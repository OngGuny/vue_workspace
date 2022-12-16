package util;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;


//418p 타이핑 

//상수아닌거 박아놓으면 컴파일해야함.  컴파일해야하면 재시작해야되기 떄문에 상수는 다 빼주는게 좋다. 
public class DBCPInitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		loadJDBCDriver();
		initConnectionPool();
	}//init
	
	private void loadJDBCDriver() {
		try {
			Class.forName("core.log.jdbc.driver.MysqlDriver"); //드라이버 로딩 여기서함. 
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		throw new RuntimeException("fail to load JDBC Driver",ex);
		}
	}//driver
	
	private void initConnectionPool() {
		try {
			String JDBC_URL = "jdbc:mysql://localhost:3306/todo?characterEncoding=UTF-8&serverTimezone=UTC";
			String JDBC_USER = "root";// 여긴다음에 파일로 가져온다
			String JDBC_PASS= "Coder.Son";
			
			ConnectionFactory connFactory = new DriverManagerConnectionFactory( JDBC_URL,JDBC_USER,JDBC_PASS );
			
			PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connFactory, null);
			poolableConnectionFactory.setValidationQuery(" select 1 ");
			
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L*60L*5L);
			poolConfig.setTestWhileIdle(true);
			poolConfig.setMinIdle(4);
			poolConfig.setMaxIdle(50);
			
			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<PoolableConnection>(poolableConnectionFactory,poolConfig);
			poolableConnectionFactory.setPool(connectionPool);
			
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");//맨뒤 세미콜론뒤에이름지정
			driver.registerPool("ConnectionPool", connectionPool);//커넥션 풀 이름 주는것. 
		}catch(Exception e) {
			//e.printStackTrace();
			throw new RuntimeException(e);
		}
	}//initcP
	
	
}//class
