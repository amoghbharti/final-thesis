# final-thesis

## Setup

Install geth on the system

Run the ethereum server on dev mode using command:
```
geth --http --dev
```

There will a `keystore` and `jwtsecret` file in `home/{$user}/.ethereum` folder. Use those in `Web3jConfig.java` file

There will a be `address` property in `keystore` JSON which we have to use in `VotingService.java`

Generate Voting class from Solidity using command
```
mvn web3j:generate-sources
```

Run the application and check the connection with geth using api:
```
http://localhost:4020/web3j/version
```