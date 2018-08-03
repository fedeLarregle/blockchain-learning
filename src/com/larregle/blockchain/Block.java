package com.larregle.blockchain;

import com.larregle.utils.Strings;

public class Block {

    private String hash;
    private String previousHash;
    private String data;
    private long timestamp;

    public Block(String data, String previousHash) {
        this.data = data;
        this.timestamp = System.currentTimeMillis();
        this.previousHash = previousHash;
        this.hash = calculateHash();
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
}
