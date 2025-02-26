pragma solidity ^0.4.18;

contract Voting {
    struct Candidate {
        uint256 id;
        bytes32 name;
        uint8 voteCount;
    }

    mapping(address => bool) public authorizedVoters;
    mapping(bytes32 => uint8) public votesReceived;
    bytes32[] public candidateList;
    mapping(bytes32 => Candidate) public candidates;
    uint256 public candidateCounter;

    constructor(bytes32[] candidateNames) public {
        for (uint256 i = 0; i < candidateNames.length; i++) {
            candidateCounter++;
            candidateList.push(candidateNames[i]);
            candidates[candidateNames[i]] = Candidate(candidateCounter, candidateNames[i], 0);
        }
    }

    // Register candidates
    function registerCandidate(bytes32 candidateName) public {
        require(!validCandidate(candidateName), "Candidate already exists");
        candidateCounter++;
        candidateList.push(candidateName);
        candidates[candidateName] = Candidate(candidateCounter, candidateName, 0);
    }

    // Get candidate count
    function getCandidateCount() public view returns (bytes32) {
        return bytes32(candidateCounter);
    }

    // Authorizes a voter by setting their address to true in the mapping
    function authorizeVoter(address voter) public {
        authorizedVoters[voter] = true;
    }

    // Vote for a candidate only if the voter is authorized
    function voteForCandidate(bytes32 candidate) public {
        require(authorizedVoters[msg.sender], "You are not authorized to vote");
        require(validCandidate(candidate), "Candidate is not valid");
        votesReceived[candidate]++;
        candidates[candidate].voteCount++;
    }

    // Returns the total votes a candidate has received so far
    function totalVotesFor(bytes32 candidate) view public returns (uint8) {
        require(validCandidate(candidate), "Candidate is not valid");
        return votesReceived[candidate];
    }

    // Verifies if the candidate is valid
    function validCandidate(bytes32 candidate) view public returns (bool) {
        for (uint256 i = 0; i < candidateList.length; i++) {
            if (candidateList[i] == candidate) {
                return true;
            }
        }
        return false;
    }

    // Returns all candidates with their vote counts
    function getResults() public view returns (uint256[], bytes32[], uint8[]) {
        uint256[] memory ids = new uint256[](candidateList.length);
        bytes32[] memory names = new bytes32[](candidateList.length);
        uint8[] memory votes = new uint8[](candidateList.length);

        for (uint256 i = 0; i < candidateList.length; i++) {
            bytes32 candidateName = candidateList[i];
            ids[i] = candidates[candidateName].id;
            names[i] = candidates[candidateName].name;
            votes[i] = candidates[candidateName].voteCount;
        }
        return (ids, names, votes);
    }
}
