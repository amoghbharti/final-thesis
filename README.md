# final-thesis

## Setup

Install geth on the system

Run the ethereum server on dev mode using command:
```
geth --http --dev
```

Get `jwtsecret` file in `home/{$user}/.ethereum` folder. Use those in `Web3jConfig.java` file

Get `keystore` JSON from `/tmp` folder which we have to use in `VotingService.java`

Generate Voting class from Solidity using command
```
mvn web3j:generate-sources
```

Run the application and check the connection with geth using api:
```
http://localhost:4020/web3j/version
```