package com.example.test_module4.repsository;

        import com.example.test_module4.model.Customer;
        import com.example.test_module4.model.Transaction;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    Page<Transaction> findAllByCustomer_NameContaining(String name, Pageable pageable);

    Page<Transaction> findAllByCustomer_NameContainingAndTransactionType_Name(String nameCustomer,String transactionType, Pageable pageable);

}

