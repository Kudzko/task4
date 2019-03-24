package by.epam.javawebtraining.kudzko.task04.model.entity;

import java.util.Objects;

public class ListingParagraph extends Paragraph {

    private String listing;

    public ListingParagraph() {
    }

    public ListingParagraph(String listing) {
        this.listing = listing;
    }

    public String getListing() {
        return listing;
    }

    public void setListing(String listing) {
        this.listing = listing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListingParagraph)) return false;
        if (!super.equals(o)) return false;
        ListingParagraph that = (ListingParagraph) o;
        return Objects.equals(listing, that.listing);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), listing);
    }

    @Override
    public String toString() {
        return "ListingParagraph{" +
                "listing='" + listing + '\'' +
                '}';
    }
}
