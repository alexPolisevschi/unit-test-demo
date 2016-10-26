package ro.alex.poll.service;

import ro.alex.poll.domain.Poll;

import java.util.Optional;

/**
 * Created by Alex P on 10/26/16.
 */
public interface PollService {

    /**
     * @param pollId to search
     * @return a Poll Optional if found, or an empty Optional otherwise
     */
    Optional<Poll> getById(Integer pollId);
}
