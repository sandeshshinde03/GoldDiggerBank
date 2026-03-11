package com.BWA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BWA.Entites.ATM;

@Repository
public interface ATMRepository extends JpaRepository<ATM, Long> {

}
