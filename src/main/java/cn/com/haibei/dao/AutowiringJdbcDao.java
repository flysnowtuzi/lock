package cn.com.haibei.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AutowiringJdbcDao extends JdbcDaoSupport {
	@Autowired
	void injectSqlMapClient(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
}
