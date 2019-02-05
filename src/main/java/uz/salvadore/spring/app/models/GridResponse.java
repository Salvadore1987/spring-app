package uz.salvadore.spring.app.models;

import java.util.List;

public class GridResponse<T> {

    private Integer totalItemsCount;
    private List<T> items;

    public Integer getTotalItemsCount() {
        return totalItemsCount;
    }

    public void setTotalItemsCount(Integer totalItemsCount) {
        this.totalItemsCount = totalItemsCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "GridResponse{" +
                "totalItemsCount=" + totalItemsCount +
                ", items=" + items +
                '}';
    }
}
