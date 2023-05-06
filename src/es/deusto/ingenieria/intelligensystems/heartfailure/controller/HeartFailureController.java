package es.deusto.ingenieria.intelligensystems.heartfailure.controller;

import es.deusto.ingenieria.intelligensystems.heartfailure.domain.Patient.ChestPainType;
import es.deusto.ingenieria.intelligensystems.heartfailure.domain.Patient.RestingElectrocardiogram;
import es.deusto.ingenieria.intelligensystems.heartfailure.domain.Patient.STSlope;
import es.deusto.ingenieria.intelligensystems.heartfailure.domain.Patient.Sex;

public class HeartFailureController {
	
	public boolean predict(short age, 
						   Sex sex,
						   ChestPainType chestPainType,
						   int restingBloodPressuere,
						   int cholesterol,
						   boolean hasFastingBloodSugar,
						   RestingElectrocardiogram restingECG,
						   int maximumHeartRate,
						   boolean hasExerciseAngina,
						   short oldpeak,
						   STSlope stSlope) {
		if ((stSlope == STSlope.UP) && (chestPainType == ChestPainType.ATA || chestPainType == ChestPainType.NAP || chestPainType == ChestPainType.TA)) {
			return false;
		}

		if ((stSlope == STSlope.DOWN || stSlope == STSlope.FLAT) && (sex == Sex.F) && ((age > 40.2 && age <= 52.5) || (age > 64.8 && age <= 77))) {
			return false;
		}

		if ((stSlope == STSlope.UP) && (chestPainType == ChestPainType.ASY) && (oldpeak < 0.45)) {
			return false;
		}

		if ((stSlope == STSlope.DOWN || stSlope == STSlope.FLAT) && (sex == Sex.F) && ((age > 28 && age <= 40.2) || (age > 52.5 && age <= 64.8))) {
			return true;
		}

		if ((stSlope == STSlope.UP) && (chestPainType == ChestPainType.ASY) && (oldpeak >= 0.45)) {
			return true;
		}

		if ((stSlope == STSlope.DOWN || stSlope == STSlope.FLAT) && (sex == Sex.M)) {
			return true;
		}

		return true;		
	}
}