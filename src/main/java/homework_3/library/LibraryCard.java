/*
 * List of ImmutableClass requirements:
 * 1) class must be final;
 * 2) all fields must be final;
 * 3) methods-mutators must return a new copy of the object;
 */

package homework_3.library;

import lombok.Getter;
import java.util.*;

@Getter
public final class LibraryCard {

    private enum Section {
        MYSTERY,
        HORROR,
        HISTORICAL,
        ROMANCE,
        SIENCE_FICTION,
        FANTASY,
        REALIST_LITERATURE
    }
    private final Author author;
    private final String title;
    private final Section section;
    private final Calendar yearOfPublishing;
    private final int numberOfPages;

    public static LibraryCard initializeNewLibraryCard (Author author, String title, GregorianCalendar yearOfPublishing, int numberOfPages, String sectionStr)
                                                        throws IllegalArgumentException {
        if (author == null
                || title == null
                || "".equals(title.trim())
                || yearOfPublishing.equals(new GregorianCalendar(0, Calendar.JANUARY, 0))
                || yearOfPublishing.after(new GregorianCalendar())
                || numberOfPages == 0) {
            throw new IllegalArgumentException();
        }
        Section section;

        if (sectionStr != null) {
            section = initializeSection(sectionStr);
        } else section = null;

        if (section == null) {
            return new LibraryCard(author, title, yearOfPublishing, numberOfPages);
        } else {
            return new LibraryCard(author, title, yearOfPublishing, numberOfPages, section);
        }
    }

    static private Section initializeSection(String sectionStr) {
        for (Section section : Section.values()) {
            if (section.equals(Section.valueOf(sectionStr.toUpperCase()))) {
                return section;
            }
        }
        return null;
    }

    public LibraryCard(Author author, String title, Calendar yearOfPublishing, int numberOfPages, Section section) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.numberOfPages = numberOfPages;
        this.section = section;
    }

    public LibraryCard(Author author, String title, Calendar yearOfPublishing, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.numberOfPages = numberOfPages;
        this.section = Section.REALIST_LITERATURE;
    }

    @Override
    public String toString() {
        return getAuthor() + " \""
                + getTitle() + " \", "
                + getYearOfPublishing().get(Calendar.YEAR) + ", "
                + getNumberOfPages() + " pp. ("
                + getSection() + ")";
    }

    public LibraryCard setAuthor(Author author) {
        return new LibraryCard(author, this.title, this.yearOfPublishing, this.numberOfPages, this.section);
    }

    public LibraryCard setTitle(String title) {
        return new LibraryCard(this.author, title, this.yearOfPublishing, this.numberOfPages, this.section);
    }

    public LibraryCard setYearOfPublishing(GregorianCalendar yearOfPublishing) {
        return new LibraryCard(this.author, this.title, yearOfPublishing, this.numberOfPages, this.section);
    }

    public LibraryCard setNumberOfPages(int numberOfPages) {
        return new LibraryCard(this.author, this.title, this.yearOfPublishing, numberOfPages, this.section);
    }

    public LibraryCard setSection(Section section) {
        return new LibraryCard(this.author, this.title, this.yearOfPublishing, this.numberOfPages, section);
    }
}
