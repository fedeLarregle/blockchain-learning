package com.larregle.blockchain;

import com.larregle.utils.Strings;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Block {

    private static final Logger logger = Logger.getLogger(Block.class.getName());

    private String hash;
    private String previousHash;
    private String data;
    private long timestamp;
    private int difficulty;
    private int nonce;

    public Block(String data, String previousHash, int difficulty) {
        this.data = data;
        this.timestamp = System.currentTimeMillis();
        this.previousHash = previousHash;
        this.nonce = 0;
        this.difficulty = difficulty;
        this.hash = calculateHash();
    }

    public void mineBlock() {
        while(!hash.substring(0, difficulty).equals(Strings.repeat("0", difficulty))) {
            nonce++;
            hash = calculateHash();
        }

        logger.log(Level.INFO, "Block was mined.");
    }

    public String calculateHash() {
        return Strings.sha256(previousHash + Long.toString(timestamp) + data);
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }
}
