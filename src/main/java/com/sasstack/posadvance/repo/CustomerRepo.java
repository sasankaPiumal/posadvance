package com.sasstack.posadvance.repo;

import com.sasstack.posadvance.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer, Long> {

    //    @Modifying
    @Query(value = "SELECT * FROM customer WHERE public_id=?1", nativeQuery = true)
    public Optional<Customer> findByPublicId(Long id);

    public void deleteByPublicIdIs(long id);

    @Query(value = "SELECT * FROM customer WHERE name LIKE %?1% OR address LIKE %?1%",nativeQuery = true)
    public Page<Customer> searchAllByAddressOrName(String searchText,Pageable pageable);

    @Query(value = "SELECT COUNT(id) FROM customer WHERE name LIKE %?1% OR address LIKE %?1%",nativeQuery = true)
    public long countDataWithSearchText(String searchText);

}
