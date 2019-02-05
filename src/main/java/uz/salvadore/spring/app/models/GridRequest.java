package uz.salvadore.spring.app.models;

import java.util.List;

public class GridRequest {

    private Integer take;
    private Integer skip;
    private String searchValue;
    private List<FilterCondition> conditions;

    public Integer getTake() {
        return take;
    }

    public void setTake(Integer take) {
        this.take = take;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<FilterCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<FilterCondition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "GridRequest{" +
                "take=" + take +
                ", skip=" + skip +
                ", searchValue='" + searchValue + '\'' +
                ", conditions=" + conditions +
                '}';
    }
}
