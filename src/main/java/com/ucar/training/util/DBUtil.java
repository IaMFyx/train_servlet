package com.ucar.training.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;

public class DBUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            Reader reader= Resources.getResourceAsReader("mybatis_config.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    public void close(SqlSession sqlSession){
        if (sqlSession!=null){
            sqlSession.close();
        }
    }
}
