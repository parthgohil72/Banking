package com.ebanking.accounts.Controller;

import com.ebanking.accounts.Constants.Constants;
import com.ebanking.accounts.DTO.CustomerDTO;
import com.ebanking.accounts.DTO.ResponseDTO;
import com.ebanking.accounts.Service.IAccountIService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class HomePageController {


    private IAccountIService iAccountIService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody CustomerDTO customerDTO) {
        iAccountIService.createAccount(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(Constants.STATUS_201, Constants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchAccountDetails(@RequestParam String number) {
        CustomerDTO customerDTO = iAccountIService.getCustomerByNumber(number);
        return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAccountDetails(@RequestBody CustomerDTO customerDTO) {
        boolean update = iAccountIService.updateAccount(customerDTO);
        if (update) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(Constants.STATUS_200, Constants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(Constants.MESSAGE_417_UPDATE, Constants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAccountDetails(@RequestParam String number) {
        boolean isDeleted = iAccountIService.deleteAccount(number);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(Constants.STATUS_200, Constants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(Constants.STATUS_417, Constants.MESSAGE_417_DELETE));
        }
    }

}
