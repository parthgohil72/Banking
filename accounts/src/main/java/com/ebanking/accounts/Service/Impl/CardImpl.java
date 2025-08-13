package com.ebanking.accounts.Service.Impl;

import com.ebanking.accounts.Constants.CardConstants;
import com.ebanking.accounts.DTO.CardDTO;
import com.ebanking.accounts.Exception.CardAlreadyExsistsException;
import com.ebanking.accounts.Model.Card;
import com.ebanking.accounts.Repository.CardRepository;
import com.ebanking.accounts.Service.ICardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardImpl implements ICardService {

    private CardRepository cardRepository;

    @Override
    public void createAdd(String number) {
        Optional<Card> optionalCard = cardRepository.findByCardNumber(number);
        if (optionalCard.isPresent()) {
            throw new CardAlreadyExsistsException("Card already registered with given mobileNumber " + number);
        }
        cardRepository.save(createNewCard(number));
    }

    private Card createNewCard(String number) {
        Card card = new Card();
        Long randomNumber = 100000000000L + new Random().nextInt(900000000);
        card.setCardNumber(String.valueOf(randomNumber));
        card.setMobileNumber(number);
        card.setCardType(CardConstants.CREDIT_CARD);
        card.setTotalLimit(CardConstants.NEW_CARD_LIMIT);
        card.setAmountUsed(0);
        card.setAvailableAmount(CardConstants.NEW_CARD_LIMIT);
        return card;
    }
}
