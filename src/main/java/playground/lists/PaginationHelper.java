package playground.lists;

import java.util.Arrays;
import java.util.List;

public class PaginationHelper<I> {

    private List<I> collection;
    private int itemsPerPage;
    private int pageCount = 0;
    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
        this.pageCount = (int)Math.ceil((double)this.collection.size() / (double)itemsPerPage);
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return this.collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {

        return this.pageCount;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex >= this.pageCount) return -1;

        return (pageIndex <= this.pageCount - 2) ?  itemsPerPage : this.collection.size() % itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= collection.size()) return -1;
        return itemIndex % this.pageCount;
    }

    public static void main(String[] args) {
        PaginationHelper<Character> helper = new PaginationHelper<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        assert 2 == helper.pageCount();

        System.out.println(helper.itemCount());
        System.out.println(helper.pageItemCount(0));
        System.out.println(helper.pageItemCount(1));
        System.out.println(helper.pageItemCount(2));
//        assert helper.itemCount()  == 6;
//         assert helper.pageItemCount(0) == 4
//        assert helper.pageItemCount(1) == 2;
//        assert helper.pageItemCount(2) == -1;

        // pageIndex takes an item index and returns the page that it belongs on
        System.out.println(helper.pageIndex(5));
        System.out.println(helper.pageIndex(2));
        System.out.println(helper.pageIndex(20));
        System.out.println(helper.pageIndex(-10));
//        assert helper.pageIndex(5)  == 1;
//        assert helper.pageIndex(2) == 0;
//        assert helper.pageIndex(20) == -1;
//        assert helper.pageIndex(-10) == -1;


    }
}