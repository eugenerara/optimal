package com.eugenerara.optimal.encryption.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Service
public class AESEncryptionServiceImpl implements EncryptionService {
    private static final String AES_ALGORITHM = "AES";
    private static final String SHA_256_ALGORITHM = "SHA-256";

    @Value("${encryption.aes.secret}")
    private String secret;


    @Override
    public void encrypt(String inputFilePath, String outputFilePath) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        generateFile(inputFilePath, outputFilePath, Cipher.ENCRYPT_MODE);
    }

    @Override
    public void decrypt(String inputFilePath, String outputFilePath) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        generateFile(inputFilePath, outputFilePath, Cipher.DECRYPT_MODE);
    }

    private void generateFile(String inputFilePath, String outputFilePath, int encryptionMode) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException {
        SecretKey secretKey = generateKey(secret);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(encryptionMode, secretKey);

        try (FileInputStream fis = new FileInputStream(inputFilePath);
             FileOutputStream fos = new FileOutputStream(outputFilePath);
             CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {

            byte[] buffer = new byte[8192];
            int count;
            while ((count = fis.read(buffer)) > 0) {
                cos.write(buffer, 0, count);
            }
        }
    }

    private SecretKey generateKey(String password) throws NoSuchAlgorithmException {
        byte[] key = password.getBytes();
        MessageDigest sha = MessageDigest.getInstance(SHA_256_ALGORITHM);
        key = sha.digest(key);
        key = Arrays.copyOf(key, 32);
        return new SecretKeySpec(key, AES_ALGORITHM);
    }
}


