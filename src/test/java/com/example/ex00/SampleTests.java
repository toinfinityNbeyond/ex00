package com.example.ex00;

import com.example.ex00.sample.Restaurant;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SampleTests {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    Restaurant restaurant;

    @Autowired
    DataSource dataSource;

    @Test
    public void testConnection() throws Exception{

        long start =System.currentTimeMillis();
        for(int i=0; i<100; i++) {//연결 100번 하는 데 0.08초 걸림(히카리 CP 썼을 때)
            //연결 횟수가 많아질수록 속도 차이는 더 커짐
            Connection connection=dataSource.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("select now()");
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            log.info(resultSet.getString(1));

            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
        long end=System.currentTimeMillis();

        log.info("--------");
        log.info(end-start);
    }


    @Test
    public void test1() {
        log.info("-------------1");
        log.info("-------------1");
        log.info(restaurant);
        log.info("-------------1");
        log.info("-------------1");
    }



}
