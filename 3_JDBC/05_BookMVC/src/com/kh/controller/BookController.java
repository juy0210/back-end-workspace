package com.kh.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.BookDAO;
import com.kh.model.dao.RentDAO;
import com.kh.model.vo.Book;

public class BookController {
	
	private BookDAO book = new BookDAO();
	private RentDAO rent = new RentDAO();
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() {
		try {
			return book.printBookAll();
		} catch (SQLException e) {
			return null;
		}
	}
	
	// 2. 책 등록
	public boolean registerBook(String title, String author) {
		try {
			// 기존 제목, 저자 있으면 등록 안되게
			if(!book.checkBook(title, author)) { // 등록 안되게=없게 하는거라서 ! 를 붙인다
				book.registerBook(title, author);
				return true;
			}
		} catch (SQLException e) {
			
		}
		return false;
		// SQL 에 SELECT * FROM book WHERE bk_title = ? AND bk_author = ? 입력
		// INSERT INTO book(bk_title, bk_author) VALUES(?, ?); 입력
	}
	
	// 3. 책 삭제
	public boolean sellBook(int no) {
		
		try {
			// 빌려있는 책 삭제 못하게!
			if(!rent.checkRentBook(no)) { // 등록 안되게=없게 하는거라서 ! 를 붙인다
				return false;
			}
			
			// 없는 번호 삭제하려고 하면 실패가 떠야지 정상!
			// --> 기존 책등 중에 해당 no가 없는 경우
			// --> 기존 책들 중에 해당 no가 있는 경우만 삭제!
			for(Book b : book.printBookAll()) {
				if(b.getBkNo()!=no) {
					book.sellBook(no);
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}








































