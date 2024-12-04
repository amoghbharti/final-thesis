package com.gm.voting;

public record VoteRequest(String voterAddress, int candidateId) {
}
