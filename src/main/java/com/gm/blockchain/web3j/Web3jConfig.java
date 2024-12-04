package com.gm.blockchain.web3j;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;

import java.util.Date;

@Configuration
public class Web3jConfig {
    @Bean
    public Web3j web3j() {
        String jwtSecretHex = "YOUR_JWT_SECRET";

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
    public Credentials credentials() {
        // Replace with your wallet's private key or keystore file
        String privateKey = "YOUR_PRIVATE_KEY";
        return Credentials.create(privateKey);
    }
}
