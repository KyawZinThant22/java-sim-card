package simcard;

public class KyawCard {
	public static void main(String[] args) {
		SimCard kyawCard = new SimCard("09407788533", "Kyaw Zin Thant", "MPT");
		
//		kyawCard.phoneCall(120);
//		System.out.println();
//		kyawCard.useInternet(5, 120);
		
		kyawCard.fillbill();
		
	}
}
