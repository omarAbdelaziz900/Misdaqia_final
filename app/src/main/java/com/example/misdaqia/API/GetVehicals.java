
package com.example.misdaqia.API;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetVehicals {

    @SerializedName("count of rows")
    @Expose
    private int countOfRows;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public int getCountOfRows() {
        return countOfRows;
    }

    public void setCountOfRows(int countOfRows) {
        this.countOfRows = countOfRows;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
