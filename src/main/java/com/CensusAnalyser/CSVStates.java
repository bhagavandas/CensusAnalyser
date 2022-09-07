package com.CensusAnalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStates {
	

    @CsvBindByName(column = "SrNo", required = true)
    public String srNo;

    @CsvBindByName(column = "State Name", required = true)
    public int stateName;

    @CsvBindByName(column = "TIN", required = true)
    public int tin;

    @CsvBindByName(column = "StateCode", required = true)
    public int stateCode;

    @Override
    public String toString() {
        return "CSVStates{" +
                "SrNo='" + srNo + '\'' +
                ", State Name='" + stateName + '\'' +
                ", TIN='" + tin + '\'' +
                ", StateCode='" + stateCode + '\'' +
                '}';
    }

}
