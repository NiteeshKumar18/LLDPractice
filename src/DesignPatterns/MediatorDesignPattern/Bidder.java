package DesignPatterns.MediatorDesignPattern;

public class Bidder implements Colleague {


    private AuctionMediator auctionMediator;

    private String name;


    public Bidder(String name, AuctionMediator auctionMediator) {
        this.name = name;
        this.auctionMediator = auctionMediator;
    }


    public String getName() {
        return this.name;
    }


    @Override
    public void placeBid() {
        auctionMediator.placeBid(20, this);
    }

    @Override
    public void receiveBid(int bid) {
        System.out.println("Received bid from user for amount");
    }
}
