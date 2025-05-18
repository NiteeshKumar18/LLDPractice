package DesignPatterns.MediatorDesignPattern;

import DesignPatterns.MediatorDesignPattern.Bidder;

public interface MediatorInterface {
    void placeBid(int amount, Bidder bidder);

    void sendMessage();

    void addBidder(Bidder bidder);

}
