package ro.alex.poll.repository;

import java.util.Optional;

/**
 * Created by Alex P on 10/26/16.
 */
public interface AddressRepository {

    Optional<String> findOneByAddressNameAndPollId(String userIpAddress, Integer pollId);
}
