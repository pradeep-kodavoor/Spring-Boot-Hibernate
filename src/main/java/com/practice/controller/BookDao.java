package com.practice.controller;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.bean.Book;

@Repository
public class BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public Book getBook(Long id){
		return getSession().load(Book.class, id);
	}

	@Transactional
	public void saveBook(Book book) {
		getSession().save(book);
	}

}
