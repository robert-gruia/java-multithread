# Street Artist Simulation

Questa simulazione rappresenta un artista di strada che esegue ritratti utilizzando carboncino. I clienti si siedono su sedie disponibili e aspettano il loro turno per farsi fare il ritratto. Le persone intorno attendono che una sedia si liberi per potersi mettere in attesa.

L'algoritmo utilizzato per sincronizzare i processi e gestire l'accesso alle sedie utilizza il meccanismo dei semafori.

## Algoritmo

1. All'inizio della simulazione, viene creato un semaforo `chairsSemaphore` con un contatore iniziale uguale al numero di sedie disponibili e un semaforo `portraitSemaphore` con un contatore iniziale uguale a 1 siccome c'è un singolo artista.

2. I clienti vengono rappresentati come thread separati. Quando un cliente arriva, cerca di acquisire una sedia utilizzando il metodo `tryAcquire()` del semaforo `chairsSemaphore`. Se riesce ad acquisire una sedia, procede ad attendere il proprio turno per fare il ritratto, turno gestito grazie al semaforo `portraitSemaphore`. Se il tempo di attesa per una sedia supera il timeout predefinito, il cliente rinuncia.

3. Il cliente occupa una sedia e il semaforo viene decrementato. Al termine del ritratto, il cliente rilascia la sedia chiamando il metodo `release()` di entrambi i semafori, consentendo ad altri clienti di occupare una sedia e ad un'altro di fare il ritratto.

4. Viene generato un numero casuale di clienti che arrivano in tempi casuali. Il tempo di esecuzione di ogni ritratto è anch'esso casuale, compreso tra un minimo e un massimo predefiniti.

## Personalizzazione

- Il numero di sedie disponibili può essere modificato impostando la costante `NUM_CHAIRS` nella classe `StreetArtistSimulation`.

- Il tempo massimo di attesa per una sedia può essere modificato impostando la costante `MAX_WAIT_TIME` nella classe `StreetArtistSimulation`.

- Il numero casuale di clienti può essere personalizzato modificando la generazione casuale nella classe `StreetArtistSimulation`.

- Il tempo di esecuzione casuale per ogni ritratto può essere personalizzato modificando la generazione casuale nella classe `Customer` nel metodo `getPortrait()`.


