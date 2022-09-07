package com.CensusAnalyser;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {

	private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.txt";
	private static final String WRONG_CSV_FILE_PATH = "./src/main/IndiaStateCensusData.csv";

	@Test
	public void givenIndianCensusCSVFileReturnsCorrectRecords() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
		}
	}

	@Test
	public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenStateCensusFileWhenIncorrectFileType_ReturnsCustomException() throws Exception {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			File filetype = new File("./src/test/resources/IndiaStateCensusData.txt");
			System.out.println(filetype);

			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(filetype, INDIA_CENSUS_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage()  + " - (Incorrect Type) This is a Sad Test Case");
			Assert.assertEquals("This is a Sad Test Case", e.getMessage());

		}
	}

	@Test
	public void givenStateCensusFileWhenIncorrectHeader_ReturnsCustomException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			File filetype = new File("./src/test/resources/IndiaStateCensusData.txt");
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(filetype, INDIA_CENSUS_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + " - (Incorrect Header) This is a Sad Test Case");
			Assert.assertEquals("This is a Sad Test Case", e.getMessage());

		}
	}
	

	@Test
	public void givenStateCensusFileWhenIncorrectDelimeter_ReturnsCustomException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			File filetype = new File("./src/test/resources/IndiaStateCensusData.txt");
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(filetype, INDIA_CENSUS_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + " - (Incorrect Delimeter) This is a Sad Test Case");
			Assert.assertEquals("This is a Sad Test Case", e.getMessage());

		}
	}
}
