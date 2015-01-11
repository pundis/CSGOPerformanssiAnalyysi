Luokkaa ProfiiliHallinta ei ole testattu automaattisesti tiedostopolkujen vaihtelun takia.

Ko. luokkaa on testattu manuaalisesti kaikilla mahdollisilla tavoilla, ja ainoa bugi johon olen törmännyt on tapaus jossa profiilit.txt tiedostosta löytyy esim. Arttu, eikä arttustatistics.txt tiedostoa ole olemassa, tällöin profiilin lataus ei onnistu.
Yllä mainittua tapausta ei voi tapahtua ellei käyttäjä ole itse käynyt poistamassa *statistics.txt tiedostoa, kun ohjelma toistetaan profiilin luomisen yhteydessä luodaan tyhjä profiilinnimistatistics.txt tiedosto.
