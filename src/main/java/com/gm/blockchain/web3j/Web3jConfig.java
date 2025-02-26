package com.gm.blockchain.web3j;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Keys;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Numeric;

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
    public Credentials credentials() {
        // Replace with your wallet's private key or keystore file
        String password = "";
        String keyStore = "{\"address\":\"f36a4f7c0543fe08b19cb9f80056910afde8d290\",\"crypto\":{\"cipher\":\"aes-128-ctr\",\"ciphertext\":\"497d513599d0bb3542b2c8e38401ed3cc881fc49adc72fea52be94becc7a67d9\",\"cipherparams\":{\"iv\":\"6b9346a22633d99df6e29b397b365ec9\"},\"kdf\":\"scrypt\",\"kdfparams\":{\"dklen\":32,\"n\":262144,\"p\":1,\"r\":8,\"salt\":\"bae725dbe5c8d8aa12cc8569777537009f161093a5330fcef33680241cab7882\"},\"mac\":\"b4d5f739252ed1de35f59125ff4f1c00011c9cca27edb28bd38ebeeb5567fe1c\"},\"id\":\"8c10c4fa-43f6-4fed-8cc6-8166d6e97ca9\",\"version\":3}";

        String privateKey = Keys.toChecksumAddress(WalletUtils.loadBip39Credentials(password, keyStore).getEcKeyPair().getPrivateKey().toString(16));
        return Credentials.create(privateKey);
    }
}
