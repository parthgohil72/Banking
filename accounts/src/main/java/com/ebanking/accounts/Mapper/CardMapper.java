package com.ebanking.accounts.Mapper;

import com.ebanking.accounts.DTO.CardDTO;
import com.ebanking.accounts.Model.Card;

public class CardMapper {

    public static CardDTO mapToCardDTO(Card card, CardDTO cardDTO) {
        cardDTO.setMobileNumber(card.getMobileNumber());
        cardDTO.setCardNumber(card.getCardNumber());
        cardDTO.setCardType(card.getCardType());
        cardDTO.setTotalLimit(card.getTotalLimit());
        cardDTO.setAmountUsed(card.getAmountUsed());
        cardDTO.setAvailableAmount(card.getAvailableAmount());
        return cardDTO;
    }

    public static Card mapToCard(CardDTO cardDTO, Card card) {
        card.setCardNumber(cardDTO.getCardNumber());
        card.setCardNumber(cardDTO.getCardNumber());
        card.setCardType(cardDTO.getCardType());
        card.setTotalLimit(cardDTO.getTotalLimit());
        card.setAmountUsed(cardDTO.getAmountUsed());
        card.setAvailableAmount(cardDTO.getAvailableAmount());
        return card;
    }
}
