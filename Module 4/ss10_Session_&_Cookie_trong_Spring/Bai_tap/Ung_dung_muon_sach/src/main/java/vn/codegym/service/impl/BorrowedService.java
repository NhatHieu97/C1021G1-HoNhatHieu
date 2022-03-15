package vn.codegym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.BorrowedBook;
import vn.codegym.repository.IBorrowedBookRepository;
import vn.codegym.service.IBorrowedBookService;
@Service
public class BorrowedService implements IBorrowedBookService {
    @Autowired
    IBorrowedBookRepository borrowedBookRepository;
    @Override
    public void save(BorrowedBook borrowedBook) {
        borrowedBookRepository.save(borrowedBook);
    }

    @Override
    public BorrowedBook findByborrowedNumber(String number) {
        return borrowedBookRepository.findByBorrowedNumberContaining(number);
    }

    @Override
    public void delete(BorrowedBook borrowedBook) {
        borrowedBookRepository.delete(borrowedBook);
    }
}
