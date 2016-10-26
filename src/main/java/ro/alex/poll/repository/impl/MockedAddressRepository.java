package ro.alex.poll.repository.impl;

import org.springframework.stereotype.Repository;
import ro.alex.poll.repository.AddressRepository;

import java.util.Optional;

/**
 * Created by Alex P on 10/26/16.
 */
@Repository
public class MockedAddressRepository implements AddressRepository {

    @Override
    public Optional<String> findOneByAddressNameAndPollId(String userIpAddress, Integer pollId) {
        return Optional.empty();
    }
}
