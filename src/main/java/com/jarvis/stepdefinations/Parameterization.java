package com.jarvis.stepdefinations;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Parameterization {
	private int i, j, r = 0;

	@Given("I have {int} and {int}")
	public void i_have_and(int i, int j) {
		this.i = i;
		this.j = j;

	}

	@When("I add them")
	public void i_add_them() {
		r = i + j;

	}

	@Then("Verify if the result is prime")
	public void verify_if_the_result_is_prime() {
		int count = 1;
		for (int i = 2; i < r; i++) {
			if (r % i == 0) {
				count++;
			}
		}
		if (count > 2) {
			System.out.println(r + " is not prime");
		} else {
			System.out.println(r + " is prime");
		}
	}

	@Given("I have <RTO_Codes> and <State_Name>")
	public void acceptRTOCodes(DataTable dt) {
		 Map stateInfo = dt.asMap();
         
		Iterator<Map.Entry> itr = stateInfo.entrySet().iterator();
		while (itr.hasNext()) {
			Entry e = itr.next();
			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}
		
	}
	}

