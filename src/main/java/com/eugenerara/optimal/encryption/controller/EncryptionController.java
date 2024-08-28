package com.eugenerara.optimal.encryption.controller;

import com.eugenerara.optimal.encryption.model.FilePathRecord;
import com.eugenerara.optimal.encryption.service.EncryptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/security")
public class EncryptionController {

    private final EncryptionService encryptionService;

    public EncryptionController(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Operation(summary = "Encrypts a file and generates an encrypted file in .enc format")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "File encrypted successfully"),
            @ApiResponse(responseCode = "400", description = "File not found"),
            @ApiResponse(responseCode = "500", description = "Encryption for file failed")
    })
    @PostMapping("/encrypt")
    public String encrypt(@Valid @RequestBody FilePathRecord filePathRecord) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        encryptionService.encrypt(filePathRecord.inputFilePath(), filePathRecord.outputFilePath());
        return "Encrypting...";
    }

    @PostMapping("/decrypt")
    public String decrypt() {
        return "Decrypting...";
    }
}
