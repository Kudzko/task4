package by.epam.javawebtraining.kudzko.task04.model.entity;

public class ListingParagrahp extends Paragrahp {

    private String listing;

    public ListingParagrahp() {
    }

    public ListingParagrahp(String listing) {
        this.listing = listing;
    }

    public String getListing() {
        return listing;
    }

    public void setListing(String listing) {
        this.listing = listing;
    }
}
