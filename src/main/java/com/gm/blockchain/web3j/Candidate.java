package com.gm.blockchain.web3j;

import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;

public class Candidate {
    private int id;
    private String name;
    private int voteCount;

    public Candidate(int id, String name, int voteCount) {
        this.id = id;
        this.name = name;
        this.voteCount = voteCount;
    }

    public Candidate(Uint256 id, Bytes32 name, Uint8 voteCount) {
        this.id = id.getValue().intValue();            // Convert Uint256 to int
        this.name = new String(name.getValue()).trim(); // Convert Bytes32 to String and trim null characters
        this.voteCount = voteCount.getValue().intValue(); // Convert Uint8 to int
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getVoteCount() { return voteCount; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setVoteCount(int voteCount) { this.voteCount = voteCount; }
}
