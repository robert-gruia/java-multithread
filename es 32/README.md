# Street Artist Simulation

Questa simulazione rappresenta un artista di strada che esegue ritratti utilizzando carboncino. I clienti si siedono su sedie disponibili e aspettano il loro turno per farsi fare il ritratto. Le persone intorno attendono che una sedia si liberi per potersi mettere in attesa.

L'algoritmo utilizzato per sincronizzare i processi e gestire l'accesso alle sedie utilizza il meccanismo dei semafori.

## Algoritmo

1. All'inizio della simulazione, viene creato un semaforo `chairsSemaphore` con un contatore iniziale uguale al numero di sedie disponibili.

2. I clienti vengono rappresentati come thread separati. Quando un cliente arriva, cerca di acquisire una sedia utilizzando il metodo `tryAcquire()` del semaforo. Se riesce ad acquisire una sedia, procede con il ritratto. Altrimenti, se il tempo di attesa supera il timeout predefinito, il cliente rinuncia al ritratto.

3. Durante l'esecuzione del ritratto, il cliente occupa una sedia e il semaforo viene decrementato. Al termine del ritratto, il cliente rilascia la sedia chiamando il metodo `release()` del semaforo, consentendo ad altri clienti di occupare una sedia.

4. La simulazione genera un numero casuale di clienti che arrivano in tempi casuali. Il tempo di esecuzione di ogni ritratto è anch'esso casuale, compreso tra un minimo e un massimo predefiniti.

## Come eseguire la simulazione

1. Compilare i file sorgenti Java con il comando: `javac Main.java StreetArtistSimulation.java Customer.java`

2. Eseguire il programma con il comando: `java Main`

3. Verrà visualizzato il numero di clienti generati casualmente. Seguiranno gli output che rappresentano l'arrivo dei clienti, l'acquisizione delle sedie, l'esecuzione del ritratto e il rilascio delle sedie.

## Personalizzazione

- Il numero di sedie disponibili può essere modificato impostando la costante `NUM_CHAIRS` nella classe `StreetArtistSimulation`.

- Il tempo massimo di attesa per una sedia può essere modificato impostando la costante `MAX_WAIT_TIME` nella classe `StreetArtistSimulation`.

- Il numero casuale di clienti può essere personalizzato modificando la generazione casuale nella classe `StreetArtistSimulation`.

- Il tempo di esecuzione casuale per ogni ritratto può essere personalizzato modificando la generazione casuale nella classe `Customer` nel metodo `getPortrait()`.


