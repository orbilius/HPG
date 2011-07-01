package se.orbilius.shared;

public class HousePriceData {

	
	private HousePriceInfoBatch batch;
	private String analysisMethod;
	public HousePriceInfoBatch getBatch() {
		return batch;
	}
	public void setBatch(HousePriceInfoBatch batch) {
		this.batch = batch;
	}
	public String getAnalysisMethod() {
		return analysisMethod;
	}
	public void setAnalysisMethod(String analysisMethod) {
		this.analysisMethod = analysisMethod;
	}
}
