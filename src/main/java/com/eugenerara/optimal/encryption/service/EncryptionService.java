package com.eugenerara.optimal.encryption.service;

import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface EncryptionService {
  /**
   * Encrypts a file
   * @param inputFilePath file to encrypt
   * @param outputFilePath encrypted file
   * @throws NoSuchAlgorithmException if the algorithm is not found
   * @throws NoSuchPaddingException if the padding is not found
   * @throws InvalidKeyException if the key is invalid
   * @throws IOException if an I/O error occurs
   */
  void encrypt(String inputFilePath, String outputFilePath) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException;

  /**
   * Decrypts a file
   * @param inputFilePath file to decrypt
   * @param outputFilePath decrypted file
   * @throws NoSuchAlgorithmException if the algorithm is not found
   * @throws NoSuchPaddingException if the padding is not found
   * @throws InvalidKeyException if the key is invalid
   * @throws IOException if an I/O error occurs
   */
  void decrypt(String inputFilePath, String outputFilePath) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException;
}
