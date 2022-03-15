package vn.codegym.service;

import vn.codegym.model.BorrowedBook;

public interface IBorrowedBookService {
    void save(BorrowedBook borrowedBook);

    BorrowedBook findByborrowedNumber(String number);
    void delete(BorrowedBook borrowedBook);
}
