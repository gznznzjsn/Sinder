package com.solvd.laba.sinder.persistence;

import com.solvd.laba.sinder.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //create this @Query
    //Page<User> findPairsFor(Long userId, Pageable pageable);

    @Query(value = """
            select *
            from sinder.users
                     inner join sinder.party_preferences on party_preferences.party_preference_id = users.user_party_preference_id
                     inner join sinder.party_preferences_party_dates on party_preferences.party_preference_id =
                                                                        party_preferences_party_dates.party_preferences_party_dates_party_preference_id
                     inner join sinder.parties on party_preferences_party_dates.party_dates = parties.party_date
                     left join party_matches pm on parties.party_id = pm.party_match_party_id and users.user_id = pm.party_match_guest_id
            where parties.party_id = ?1
            and (party_match_status IS NULL or party_match_status='REQUESTED')""", nativeQuery = true)
    Page<User> findGuestsFor(Long partyId, Pageable pageable);

    Boolean existsByEmail(String email);

}
