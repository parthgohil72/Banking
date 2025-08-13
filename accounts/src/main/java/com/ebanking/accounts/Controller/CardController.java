package com.ebanking.accounts.Controller;

import com.ebanking.accounts.Constants.CardConstants;
import com.ebanking.accounts.DTO.CardDTO;
import com.ebanking.accounts.DTO.ResponseDTO;
import com.ebanking.accounts.Service.ICardService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/card", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Validated
public class CardController {

    private final ICardService iCardService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createCard(@Valid @RequestParam
                                                      @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                      String number) {
        iCardService.createAdd(number);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(CardConstants.STATUS_201, CardConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CardDTO> fetchCard(@RequestParam
                                                       @Pattern(regexp = "(^$|[0-9]{10})", message = "AccountNumber must be 10 digits")
                                                       String number) {
        CardDTO cardDTO = iCardService.fetchCard(number);
        return ResponseEntity.status(HttpStatus.OK).body(cardDTO);
    }
}
