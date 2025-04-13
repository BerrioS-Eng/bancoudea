package com.udea.bancoudea.controller;

import com.udea.bancoudea.DTO.TransactionDTO;
import com.udea.bancoudea.DTO.TransactionWithoutTimeDTO;
import com.udea.bancoudea.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionFacade;

    public TransactionController(TransactionService transactionFacade) {
        this.transactionFacade = transactionFacade;
    }

    //Obtener lista de transacciones según número de cuenta
    @GetMapping("/{account}")
    public ResponseEntity<List<TransactionDTO>> getAllTransactionsByAccountNumber(@PathVariable String account) {
        return ResponseEntity.ok(transactionFacade.getTransactionsForAccount(account));
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionWithoutTimeDTO transactionWithoutTimeDTO) {
        TransactionDTO transaction = new TransactionDTO();
        transaction.setReceiverAccountNumber(transactionWithoutTimeDTO.getReceiverAccountNumber());
        transaction.setSenderAccountNumber(transactionWithoutTimeDTO.getSenderAccountNumber());
        transaction.setAmount(transactionWithoutTimeDTO.getAmount());
        transaction.setTimestamp(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        System.out.println(transaction.toString());
        return ResponseEntity.ok(transactionFacade.transferMoney(transaction));
    }
}
