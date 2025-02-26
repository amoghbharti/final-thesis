package com.gm.voting;

import com.gm.blockchain.web3j.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/voting")
public class VotingController {

    @Autowired
    private VotingService votingService;

    @PostMapping("/registerVoter")
    public ResponseEntity<String> registerVoter(@RequestBody String voterAddress) throws Exception {
        votingService.registerVoter(voterAddress);
        return ResponseEntity.ok("Voter Registered Successfully.");
    }

    @PostMapping("/vote")
    public ResponseEntity<String> vote(@RequestBody VoteRequest voteRequest) throws Exception {
        votingService.vote(voteRequest.voterAddress(), voteRequest.candidateId());
        return ResponseEntity.ok("Vote Cast Successfully.");
    }

    @GetMapping("/results")
    public ResponseEntity<List<Candidate>> getResults() throws Exception {
        List<Candidate> results = votingService.getResults();
        return ResponseEntity.ok(results);
    }
}
