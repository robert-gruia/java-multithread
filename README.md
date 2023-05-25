# Street Artist Simulation

Questa simulazione rappresenta un artista di strada che esegue ritratti utilizzando carboncino. I clienti si siedono su sedie disponibili e aspettano il loro turno per farsi fare il ritratto. Le persone intorno attendono che una sedia si liberi per potersi mettere in attesa.

L'algoritmo utilizzato per sincronizzare i processi e gestire l'accesso alle sedie utilizza il meccanismo dei semafori.

## Algoritmo

1. All'avvio del programma vengono istanziati 2 semafori a conteggio nella classe `StreetArtistSimulation`:
    - `chairsSemaphore` &rarr; gestisce l'occupazione delle sedie:
        - semaforo a conteggio con limite gestito dalla costante `NUM_CHAIRS` 
    - `portraitSemaphore` &rarr; gestisce i turni per il ritratto.

2. I clienti vengono istanziati come thread separati e al loro avvio si metteranno in attesa apettando di acquisire una sedia utilizzando il metodo `tryAcquire()` del semaforo `chairsSemaphore`. In caso passi uno specifico periodo di tempo (`MAX_WAIT_TIME`) senza acquisire una sedia il cliente andrà via.

3. In caso il cliente riesca ad acquisire un posto nella fila di sedie si metterà in attesa aspettando il proprio ritratto. Quest'attesa viene gestita dal semaforo `portraitSemaphore` attraverso il suo metodo `tryAcquire()`.

4. Al termine del ritratto il cliente interessato si alzerà dalla sedia e se ne andrà liberando `portraitSemaphore` e 1 posto del `chairsSemaphore`.

## Personalizzazione

- Il numero di sedie disponibili può essere modificato impostando la costante `NUM_CHAIRS` nella classe `StreetArtistSimulation`.

- Il tempo massimo di attesa per una sedia può essere modificato impostando la costante `MAX_WAIT_TIME` nella classe `StreetArtistSimulation`.

- Il numero casuale di clienti può essere personalizzato modificando la generazione casuale nella classe `StreetArtistSimulation`.

- Il tempo di esecuzione casuale per ogni ritratto può essere personalizzato modificando la generazione casuale nella classe `Customer` nel metodo `getPortrait()`.


