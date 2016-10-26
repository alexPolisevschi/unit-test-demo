package ro.alex.poll.service.impl;

import org.springframework.stereotype.Service;
import ro.alex.poll.domain.Poll;
import ro.alex.poll.service.VoteService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Alex P on 10/26/16.
 */
@Service
public class MockedVoteService implements VoteService {

    @Override
    public void registerVote(Poll poll, List<Integer> selectedAnswers, HttpServletRequest request) {
        //
    }
}
