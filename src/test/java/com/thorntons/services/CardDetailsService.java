package com.thorntons.services;

import com.thorntons.model.CardDetails;

public class CardDetailsService {


    //TODO get details from json using cardType. This is temporary in the mean time
    public CardDetails getCardByType(String cardType) {
        CardDetails cardDetails = null;
        switch (cardType) {
            case "Visa":
                cardDetails = getVisaDetails();
            case "Amex" :
                cardDetails = getAmexDetails();
        }
        if(cardDetails == null)
            throw new RuntimeException("no details found. check value of card type supplied");
        return cardDetails;
    }

    private CardDetails getVisaDetails() {
        CardDetails cardDetails = new CardDetails();
        cardDetails.setCardNumber("4000 0000 0000 0002");
        cardDetails.setCardType("Visa");
        cardDetails.setcVV("000");
        return cardDetails;
    }

    private CardDetails getAmexDetails(){
        CardDetails cardDetails = new CardDetails();
        cardDetails.setCardNumber("3742 4545 5400 001");
        cardDetails.setCardType("American Express");
        cardDetails.setcVV("0000");
        return cardDetails;
    }

}
