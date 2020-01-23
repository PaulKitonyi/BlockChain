/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paul.blockchain;

import java.util.Date;

/**
 *
 * @author h4ck3r
 */
public class Block {
    public int id;
    public int nonce;
    public long timestamp;
    public String hash;
    public String previousHash;
    public String transaction;
    
    
    public Block(int id, String transaction, String previousHash){
        this.id = id;
        this.transaction = transaction;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();
        generateHash();
    }
    
    public void generateHash(){
        String dataToHash = Integer.toString(getId()) + getPreviousHash() + Long.toString(getTimestamp()) + Integer.toString(getNonce());
        String hashValue = SHA256Helper.generateHash(dataToHash);
        this.setHash(hashValue);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
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
    
    public void incrementNonce(){
        this.nonce++;
    }
    
    public String toString(){
        return this.id + "-" + this.transaction + "-" + this.hash + "-" + this.previousHash +"-";
    }
    
}
