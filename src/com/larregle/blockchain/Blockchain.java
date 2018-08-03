package com.larregle.blockchain;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {

    private final List<Block> blockchain;


    public Blockchain() {
        blockchain = new ArrayList<>();
        genesisBlock();
    }

    private void genesisBlock() {
        blockchain.add(new Block("Genesis Block", null));
    }

    public Block getLatestBlock() { return blockchain.get(blockchain.size() - 1); }

    public void addBlock(Block block) {
        block.setPreviousHash(getLatestBlock().getHash());
        block.setHash(block.calculateHash());
        blockchain.add(block);
    }

    public boolean isValidBlock() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);

            if (!currentBlock.getHash().equals(currentBlock.calculateHash()))
                return false;

            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash()))
                return false;
        }
        return true;
    }
}
