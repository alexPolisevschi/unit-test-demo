package ro.alex.poll.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.alex.poll.service.PollService;
import ro.alex.poll.service.SecurityService;
import ro.alex.poll.service.VoteService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex P on 10/26/16.
 */
@RestController
@RequestMapping("/pollingApi/")
public class VotingRestController {

    @Autowired
    private PollService pollService;

    @Autowired
    private VoteService voteService;

    @Autowired
    private SecurityService securityService;


    @RequestMapping(value="/polls/{pollId}/vote",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity vote(@PathVariable final Integer pollId,
                               @RequestParam final List<Integer> selectedAnswers,
                               final HttpServletRequest request,
                               HttpServletResponse response) {

        if(selectedAnswers.isEmpty()) {
            return new ResponseEntity("At least one answer is required", HttpStatus.BAD_REQUEST);
        }

        return pollService.getById(pollId)
            .map(poll -> {
                if(securityService.allowVote(poll, request)) {
                    // Should verify number of answers if the poll allows only a single answer

                    voteService.registerVote(poll, selectedAnswers, request);
                    securityService.registerCookie(poll, response);

                    return new ResponseEntity(HttpStatus.CREATED);
                }

                return new ResponseEntity("You already voted in this poll!", HttpStatus.FORBIDDEN);
            })
            .orElse(new ResponseEntity("Poll doesn't exist", HttpStatus.NOT_FOUND));
    }

}
