CSGOPerformanssiAnalyysi rakennekuvaus

 Paaohjelma aloittaa luomalla NakymaHallitsijan ja GraafinenKayttoliittyma oliot, se luo myös ProfiiliHallinta olion jonka se antaa NakymaHallitsijalle.
Tästä eteenpäin NakymaHallitsija luokka ohjaa GUI:n näkymää, aina kun käyttäjä haluaa siirtyä näkymästä toiseen, välittyy kutsut NakymaHallitsijan kautta.

Kun profiililatausnäkymästä ladataan olemassa oleva profiili, lukee ProfiiliHallinta luokka tekstitiedostoihin talletetun datan ja luo niiden pohjalta uuden Profiili olion ja syöttää sille PelattuKartta olioita jotka Profiili taltio tietorakenteisiin.

Kun taas ProfiiliNakymaan siirrytään, luodaan ProfiiliAnalyysi luokka jota NakymaHallitsija käyttää tulostaakseen karttojen statistiikat.

Aina kun ProfiiliNäkymässä tapahtuu muutoksia, välittyy tieto siitä NakymaHallitsija luokalle joka päivittää GUI:n ja ProfiiliHallinta luokan välityksellä tallentaa muutokset.
