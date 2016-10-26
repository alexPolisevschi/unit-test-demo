package ro.alex.poll.service.impl;

import org.springframework.stereotype.Service;
import ro.alex.poll.constants.SecurityType;
import ro.alex.poll.domain.Poll;
import ro.alex.poll.service.PollService;

import java.util.Optional;

/**
 * Created by Alex P on 10/26/16.
 */
@Service
public class MockedPollService implements PollService {

    @Override
    public Optional<Poll> getById(Integer pollId) {
        Poll testPoll = new Poll();

        testPoll.setId(pollId);
        testPoll.setQuestion("No question?");
        testPoll.setSecurityType(SecurityType.IP);

        return Optional.of(testPoll);
    }
}
