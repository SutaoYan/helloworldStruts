package com.apress.bookstore.controller;

import java.util.List;
import java.util.Map;

import com.apress.books.dao.BookDAOImpl;
import com.apress.books.model.Category;
import com.apress.books.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class BookController extends ActionSupport {

	// properties
	private String username;
	private String password;	
	private User user;
	private List<Category> categories;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void setCategoryList(List<Category> categories) {
		this.categories = categories;
	}
	public List<Category> getCategoryList() {
		return this.categories;
	}
	
	public String login() {
		return "login";
	}
	
	public String executelogin() {
		String executelogin = "failed";
		Map<String, Object> session = ActionContext.getContext().getSession();
		BookDAOImpl dao = new BookDAOImpl();
		User user = new com.apress.books.model.User();
		user.setUserName(getUsername());
		user.setPassword(getPassword());
		setUser(user);
		if (dao.isUserAllowed(user)) {
			setCategoryList(dao.findAllCategories());
			session.put("username", user.getUserName());
			session.put("categoryList", getCategoryList());
			executelogin = "allBooks";
		} else {
			addActionError(getText("error.login"));
			return "error";
		}
		// return result;
		return executelogin;
	}

	private void setUser(User user2) {
		this.user = user2;
		// TODO Auto-generated method stub
		
	}

	public String error() {
		return "error";
	}

	public String allBooks() {
		return null;
	}

	public String booksByCategory() {
        BookDAOImpl dao = new BookDAOImpl();
//        setBookList(dao.findBooksByCategory(categories));
        return "booksByCategory";
}

	public String searchByKeyword() {
		return null;
	}

	public String home() {
		return "home";
	}

	public String selectedBooks() {
		return null;
	}

	public String logout() {
		return "logout";
	}

	// getters and setters

}