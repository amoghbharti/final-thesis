package com.gm.blockchain.web3j;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Keys;
import org.web3j.crypto.WalletUtils;
import org.web3j.crypto.exception.CipherException;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Configuration
public class Web3jConfig {
    @Bean
    public Web3j web3j() {
        String jwtSecretHex = "0xed5b4ddb73391ac8b45cfdb596d5012d9eb0100acf9481777e118068c884ea93";

        byte[] jwtSecretBytes = Numeric.hexStringToByteArray(jwtSecretHex);

        // Generate a JWT token using the secret
        Algorithm algorithm = Algorithm.HMAC256(jwtSecretBytes);
        String jwtToken = JWT.create()
                .withIssuedAt(new Date())
                .sign(algorithm);

        HttpService httpService = new HttpService("http://127.0.0.1:8545"); // replace with your Ethereum node URL
        httpService.addHeader("Authorization", "Bearer " + jwtToken);

        return Web3j.build(httpService);
    }

    @Bean
    public Credentials credentials() throws IOException, CipherException {
        // Replace with your wallet's private key or keystore file
        String password = "";
        String keyStore = "{\"address\":\"bfd998d50974d48c35d12b1f6489a2661bc66b00\",\"crypto\":{\"cipher\":\"aes-128-ctr\",\"ciphertext\":\"0c956121523e28923d681c5697017be2b252fc9c938112d882353e3a8b9d584e\",\"cipherparams\":{\"iv\":\"163219b2b08228c60424acb4562ede07\"},\"kdf\":\"scrypt\",\"kdfparams\":{\"dklen\":32,\"n\":4096,\"p\":6,\"r\":8,\"salt\":\"7ddd3ddcaeefbac2b2dec51d636001a3c13066513d57ab20477d477365ab7508\"},\"mac\":\"8788d7f3762a23ddb627d52d624b5a87d416579706052bb0695fd40db8d673b6\"},\"id\":\"54c887a4-9cee-4141-8848-991a02f2b30f\",\"version\":3}";

        String privateKey = Keys.toChecksumAddress(WalletUtils.loadJsonCredentials(password, keyStore).getEcKeyPair().getPrivateKey().toString(16));
        return Credentials.create(privateKey);
    }
}
