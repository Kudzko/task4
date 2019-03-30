package by.epam.javawebtraining.kudzko.task04.model.entity;

import by.epam.javawebtraining.kudzko.task04.model.entity.exception.logicexception.MismatchTypesException;

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
    public void addElement(TextElement element) throws MismatchTypesException {
        throw new UnsupportedOperationException();
//log
    }

    @Override
    public TextElement getChild(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getAmountElements() {
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if ((o == null)|| (o.getClass() != this.getClass())) return false;
        if (this == o) return true;
        ListingParagraph that = (ListingParagraph) o;
        return Objects.equals(listing, that.listing);
    }

    @Override
    public int hashCode() {

        return Objects.hash(listing);
    }

    @Override
    public String toString() {
        return listing;
    }
}
