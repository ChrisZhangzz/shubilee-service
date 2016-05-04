package com.shubilee.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ComputerResult {
	
    private BigDecimal computerPrice;

    private List<ComputerGoodResult> computerGoodResult;



	public BigDecimal getComputerPrice() {
		return computerPrice;
	}

	public void setComputerPrice(BigDecimal computerPrice) {
		this.computerPrice = computerPrice;
	}

	public List<ComputerGoodResult> getComputerGoodResult() {
		return computerGoodResult;
	}

	public void setComputerGoodResult(List<ComputerGoodResult> computerGoodResult) {
		this.computerGoodResult = computerGoodResult;
	}

    



    
}
