package ro.alex.poll.service;

import ro.alex.poll.domain.Poll;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Alex P on 10/26/16.
 */
public interface VoteService {

    /**
     * Adds the selected answers to the poll.
     * Adds the IP of the user that voted in the database (regardless of poll security settings)
     */
    void registerVote(Poll poll, List<Integer> selectedAnswers, HttpServletRequest request);
}
