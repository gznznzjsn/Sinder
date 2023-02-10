package com.solvd.laba.sinder.persistence;

import com.solvd.laba.sinder.domain.Party;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {

    @Query(value = """
            select parties.*
            from parties
            inner join party_preferences_party_dates on party_preferences_party_dates.party_dates = parties.party_date
            inner join party_preferences on party_preferences.party_preference_id = party_preferences_party_dates.party_preferences_party_dates_party_preference_id
            inner join users on users.user_party_preference_id = party_preferences.party_preference_id
            left join party_matches pm on parties.party_id = pm.party_match_party_id and users.user_id = pm.party_match_guest_id
            where users.user_id = ?1
            and users.user_id<>parties.party_creator_id
            and parties.published = true
            and party_match_status is null or party_match_status='INVITED';
            """, nativeQuery = true)
    Page<Party> findPartiesFor(Long userId, Pageable pageable);

}
