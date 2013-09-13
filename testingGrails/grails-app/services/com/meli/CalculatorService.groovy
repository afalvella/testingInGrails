package com.meli

class CalculatorService {

    def getParity(Integer number) {
		if( number.mod(2) == 0 ){
			return "Even"
		}else{
			return "Odd"
		}
    }
}
