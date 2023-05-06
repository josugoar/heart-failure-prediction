package es.deusto.ingenieria.intelligensystems.heartfailure.domain;

public class Patient {

	public enum Sex {
		U("Unknown"), F("Female"), M("Male");

		private String description;

		private Sex(String description) {
			this.description = description;
		}

		public String toString() {
			return description;
		}
	}

	public enum ChestPainType {
		U("Unknown"), TA("Typical Angina"), ATA("Atypical Angina"), NAP("Non-Anginal Pain"), ASY("Asymptomatic");

		private String description;

		private ChestPainType(String description) {
			this.description = description;
		}

		public String toString() {
			return description;
		}
	}

	public enum RestingElectrocardiogram {
		U("Unknown"), NORMAL("Normal"), ST("Having ST-T wave abnormality"),
		LVH("Showing probable or definite left ventricular hypertrophy by Estes' criteria");

		private String description;

		private RestingElectrocardiogram(String description) {
			this.description = description;
		}

		public String toString() {
			return description;
		}
	}

	public enum STSlope {
		U("Unknown"), UP("Up"), FLAT("Flat"), DOWN("Down");

		private String description;

		private STSlope(String description) {
			this.description = description;
		}

		public String toString() {
			return description;
		}
	}

	private short age;
	private Sex sex;
	private ChestPainType chestPainType;
	private int restingBloodPressuere;
	private int cholesterol;
	private boolean hasFastingBloodSugar;
	private RestingElectrocardiogram restingECG;
	private int maximumHeartRate;
	private boolean hasExerciseAngina;
	private short oldpeak;
	private STSlope stSlope;
	private boolean hasHeartDisease;

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public ChestPainType getChestPainType() {
		return chestPainType;
	}

	public void setChestPainType(ChestPainType chestPainType) {
		this.chestPainType = chestPainType;
	}

	public int getRestingBloodPressuere() {
		return restingBloodPressuere;
	}

	public void setRestingBloodPressuere(int restingBloodPressuere) {
		this.restingBloodPressuere = restingBloodPressuere;
	}

	public int getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(int cholesterol) {
		this.cholesterol = cholesterol;
	}

	public boolean isHasFastingBloodSugar() {
		return hasFastingBloodSugar;
	}

	public void setHasFastingBloodSugar(boolean hasFastingBloodSugar) {
		this.hasFastingBloodSugar = hasFastingBloodSugar;
	}

	public RestingElectrocardiogram getRestingECG() {
		return restingECG;
	}

	public void setRestingECG(RestingElectrocardiogram restingECG) {
		this.restingECG = restingECG;
	}

	public int getMaximumHeartRate() {
		return maximumHeartRate;
	}

	public void setMaximumHeartRate(int maximumHeartRate) {
		this.maximumHeartRate = maximumHeartRate;
	}

	public boolean isHasExerciseAngina() {
		return hasExerciseAngina;
	}

	public void setHasExerciseAngina(boolean hasExerciseAngina) {
		this.hasExerciseAngina = hasExerciseAngina;
	}

	public short getOldpeak() {
		return oldpeak;
	}

	public void setOldpeak(short oldpeak) {
		this.oldpeak = oldpeak;
	}

	public STSlope getStSlope() {
		return stSlope;
	}

	public void setStSlope(STSlope stSlope) {
		this.stSlope = stSlope;
	}

	public boolean isHasHeartDisease() {
		return hasHeartDisease;
	}

	public void setHasHeartDisease(boolean hasHeartDisease) {
		this.hasHeartDisease = hasHeartDisease;
	}
}