package com.spring.app.entities;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.app.configuration.AppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfiguration.class)

@Transactional			//makes every method transactional, so that after method is executed the changes are rolled back
public class HibernateUserRepositoryTest {

}
