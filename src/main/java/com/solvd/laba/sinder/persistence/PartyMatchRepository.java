package com.solvd.laba.sinder.persistence;

import com.solvd.laba.sinder.domain.partymatch.PartyMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyMatchRepository extends JpaRepository<PartyMatch, Long> {

}
