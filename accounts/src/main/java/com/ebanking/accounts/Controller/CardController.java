package com.ebanking.accounts.Controller;

import com.ebanking.accounts.Constants.CardConstants;
import com.ebanking.accounts.Constants.Constants;
import com.ebanking.accounts.DTO.CustomerDTO;
import com.ebanking.accounts.DTO.ResponseDTO;
import com.ebanking.accounts.Service.ICardService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/card", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CardController {

    private final ICardService iCardService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createCard(@Valid @RequestBody String number) {
        iCardService.createAdd(number);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(CardConstants.STATUS_201, CardConstants.MESSAGE_201));
    }
}
