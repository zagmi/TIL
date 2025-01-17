package servlet.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servelt.model.book.BookDAOimpl;
import servelt.model.book.BookVo;
import servelt.model.user.UserDAOimpl;
import servelt.model.user.UserVo;

@WebServlet("/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String path = "login.jsp";
		
		if(req.getParameter("command").equals("login")) {
			path = login(req,res);
		}else if(req.getParameter("command").equals("logout")) {
			path = logout(req,res);
		}else if(req.getParameter("command").equals("book")) {
			path = book(req,res);
		}else if(req.getParameter("command").equals("booklist")) {
			path = showAllBook(req,res);
		}else if(req.getParameter("command").equals("search")) {
			path = search(req,res);
		}
		else {
			path = bookInfo(req,res);
		}
		
		req.getRequestDispatcher(path).forward(req, res);
	}


	
	
	private String login(HttpServletRequest req, HttpServletResponse res) {
		String path = "login.jsp";
		
		String id= req.getParameter("id");
		String pass= req.getParameter("pass");

		//dao biz
		UserDAOimpl dao = UserDAOimpl.getInstance();
		try {
			UserVo user = dao.login(id, pass);
			if(user != null) {
				HttpSession session = req.getSession();
				session.setAttribute("vo", user);
				path= "loginSucess.jsp";
			}
			else {
				path = "error.jsp";
			}
		} catch (SQLException e) {
			System.out.println("Main ServletDB연결 에러*****");
		}
		
		return path;
	}


	private String logout(HttpServletRequest req, HttpServletResponse res) {
		String path = "login.jsp";
		HttpSession session = req.getSession();
		
		if(session.getAttribute("vo")!=null) session.invalidate();
		path = "logout.jsp";
		return path;
	}


	private String book(HttpServletRequest req, HttpServletResponse res) {
		String path = "login.jsp";
		Date publish_date = null;
		int price = 0;
		
		//값 받아와서
		String isbn = req.getParameter("isbn1")+"-"+req.getParameter("isbn2")+"-"+req.getParameter("isbn3");
		String title = req.getParameter("title");
		String catalogue = req.getParameter("kinds");
		String nation = req.getParameter("country");
	
		if (req.getParameter("release").equals("")) {
			publish_date = Date.valueOf("9999-12-13");
		}else {
		 publish_date = Date.valueOf(req.getParameter("release"));}
	
		String publisher = req.getParameter("publisher ");
		String author = req.getParameter("writer");
		
		if(req.getParameter("price").equals("")) {
			price = 0;
		}else {
		price = Integer.parseInt(req.getParameter("price"));}
		
		String currency = req.getParameter("unit");
		String desc = req.getParameter("desc");
		
		
		//객체생성
		BookVo book = new BookVo(isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, desc);
		System.out.println(book.toString());
		
		
		//dao bizs
		BookDAOimpl dao = BookDAOimpl.getInstance();
		try {
			dao.bookRegister(book);
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("bookRegister SQL오류");
		}
		req.setAttribute("book", book);
		path = "book/result.jsp";
		
		return path;
	}


	private String showAllBook(HttpServletRequest req, HttpServletResponse res) {
		String path = "login.jsp";
		BookDAOimpl dao = BookDAOimpl.getInstance();
		ArrayList<BookVo> books = new ArrayList<>();
		
		try {
			books = dao.showAllbook();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("showAllbook sql 오류");
		}
		req.setAttribute("books", books);
		path = "book/bookList.jsp";
		return path;
	}
	
	private String search(HttpServletRequest req, HttpServletResponse res) {
		String path = "login.jsp";
		
		String sort = req.getParameter("sort");
		String word = req.getParameter("word");
		BookDAOimpl dao = BookDAOimpl.getInstance();
		ArrayList<BookVo> books = new ArrayList<>();
		
		try {
			books = dao.search(sort, word);
			req.setAttribute("books", books);
			path = "book/bookList.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	private String bookInfo(HttpServletRequest req, HttpServletResponse res) {
		String path="login.jsp";
		String title = req.getParameter("title");
		BookDAOimpl dao = BookDAOimpl.getInstance();
		
		try {
			BookVo book = dao.bookInfo(title);
			String info = "책 상세정보 출력 - 제목: "+book.getTitle()+", 출판사: "+book.getPublisher()+", 저자: "+book.getAuthor();
			req.setAttribute("info", info);
			path="book/bookinfo.jsp";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return path;
	}

}
