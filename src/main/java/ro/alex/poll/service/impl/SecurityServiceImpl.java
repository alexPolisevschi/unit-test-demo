package ro.alex.poll.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.alex.poll.constants.SecurityType;
import ro.alex.poll.domain.Poll;
import ro.alex.poll.repository.AddressRepository;
import ro.alex.poll.service.SecurityService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Alex P on 10/26/16.
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    private static final String POLL_COOKIE = "POLL_COOKIE";

    private static Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);


    @Autowired
    private AddressRepository addressRepository;


    @Override
    public boolean allowVote(Poll poll, HttpServletRequest request) {
        boolean allowVote = true;

        if (SecurityType.COOKIE.equals(poll.getSecurityType())) {
            allowVote = validateByCookie(poll, request);

        } else if (SecurityType.IP.equals(poll.getSecurityType())) {
            allowVote = validateByIP(poll, request);
        }

        logger.info("allowVote(): Exit with result {}. Poll {}, Security {}", allowVote, poll.getId(), poll.getSecurityType());
        return allowVote;
    }


    private boolean validateByCookie(Poll poll, HttpServletRequest request) {
        String cookieName = computeCookieNameByPollId(poll);

        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookieName.equals(cookie.getName())) {
                    return false;
                }
            }
        }
        return true;
    }

    private String computeCookieNameByPollId(Poll poll) {
        return POLL_COOKIE + "_" + poll.getId();
    }


    private boolean validateByIP(Poll poll, HttpServletRequest request) {
        return !addressRepository.findOneByAddressNameAndPollId(request.getRemoteAddr(), poll.getId()).isPresent();
    }


    @Override
    public void registerCookie(Poll poll, HttpServletResponse response) {
        Cookie cookie = new Cookie(computeCookieNameByPollId(poll), "VOTED");
        response.addCookie(cookie);
    }

}
