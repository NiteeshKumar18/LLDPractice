package DesignPatterns.MediatorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class AuctionMediator implements MediatorInterface {

    private List<Bidder> allBidders = new ArrayList<>();


    @Override
    public void placeBid(int amount, Bidder bidder) {
        for (Bidder bidderLocal : allBidders) {
            if (!bidderLocal.getName().equals(bidder.getName())) {
                bidderLocal.receiveBid(amount);
            }
        }
    }

    @Override
    public void sendMessage() {

    }

    @Override
    public void addBidder(Bidder bidder) {
        this.allBidders.add(bidder);
    }

}
