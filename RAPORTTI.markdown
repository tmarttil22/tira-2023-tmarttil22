# Raportit tehtävistä

Kirjaa tähän tiedostoon **jokaiseen** tehtävään liittyvät omat raporttisi ja analyysisi. Muista että raportti on myös kurssilla **arvosteltava tehtävä**.

Voit sisällyttää raporttiin tekstimuotoisia taulukoita (tasaukset välilyönnein):

```
n     Fill     Search   Total
500   7        700      707
1000  9        288      297
```

Ja näihin liittyviä kuvatiedostoja:

![Esimerkkikuva](report-sample-image.png)

Nämä näkyvät sitten VS Coden Preview -näkymässä (tai oman repositorysi webbisivulla) oikein muotoiltuna. Käytä tässä dokumentissa olevia muotoiluja esimerkkinä kun kirjoitat raporttiasi. 

Huomaa että jos laitat kuvatiedostot vaikka omaan alihakemistoonsa, Markdown -muotoilussa on oltava suhteellinen polku tiedostoon, esimerkiksi `images/report-sample-image.png`. **Älä** käytä absoluuttisia polkuja `C:\Users\tippaleipa\kurssit\TIRA\kuva.png`, koska nämä eivät tietenkään toimi opettajan koneella. Ei kannata laittaa linkkiä etärepoosikaan, vaan nimenomaan paikalliseen tiedostoon.

Voit myös sisällyttää *lyhyitä* koodinpätkiä vaikkapa Java -formaatilla:

```Java
	@Override
	public int hashCode() {
		// Oma nerokas hajautufunktioni!
	}
```
Tarvittaessa käytä myös paremmin muotoiltuja taulukoita:

| n	| Fill	| Search	| Total |
|-----|--------|--------|-------|
| 500	 | 7	| 700	| 707 |
| 1000 |	9	| 288	| 297 | 

Alaluvut jokaisen tehtävän raportille löydät alta.


## 01-TASK
Tehtävän tekemisessä opin päällimmäisenä, että while- lauseen (ja oletettavasti kaikki samankaltainen) ehdon järjestyksellä on väliä, kun ne erotellaan '&&' merkillä.
"while (j >= 0 && current.compareTo(array[j]) < 0)" otti sorttaamiseen mukaan arrayn ensimmäisen elementin, samalla kun "while (current.compareTo(array[j] && j >= 0) < 0)" koodilla arrayn ensimmäinen elementti pysyi aina paikallaan.
Sanoisin että reverse() metodien luominen oli jokseenkin helppoa, mutta itse insertionSort() metodien äärellä jouduin ajattelemaan, käyttämään enemmän aikaa ymmärtämiseen.

Aikakompleksisuusluokat molemmille insertionSort() sekä reverse() metodeille O(n) eli lineaariset.

Jos taulukko on jo valmiiksi järjestyksessä nousevaan järjestykseen, ja se aiotaan lajitella laskevaan järjestykseen,
sen järjestys kannattaa vaihtaa sillä for-loop käydään läpi "array.length / 2" verran, samalla kun lajittelumetodissa se käydään läpi "array.length" verran.



## 02-TASK
Tehtävässä opin koodin korjaamista ja vian löytämistä seuraamalla missä virheet ovat tapahtuneet katsomalla virheilmoituksia, käymällä kaikki funktiokutsut mitkä johtavat tähän virheeseen läpi ja tarkasti ajatellen sekä pohtien huomaten, mikä ongelman juuri on.
Vaikeaksi koin aluksi Comparable-rajapinnan ymmärtämisen mutta sain sen ymmärretyksi kun käsittelin metodeita mihin sen käyttö kuului.

// täytä tähän kun saat lajittelun toimimaan sovelluksessa

Jos aineisto on jo valmiiksi lajiteltu, kannattaa käyttää reverse-algoritmia, sillä sillä tavalla täytyy käydä vain puolet aineiston alkioista läpi, säästäen aikaa.

Toteutettuja algoritmejä kutsutaan lineaarisiksi, koska niiden suoritusaika kasvaa lineaarisesti (suoraan) ylöspäin n:n kasvaessa. Big-O notaatiossa tätä merkitään O(n).

Kuvasta voidaan päätellä, että täyttöajan aikakompleksisuus on O(n), mutta hakuajan aikakompleksisuus pysyy aikalailla samana, lukuun ottamatta alkua jossa suhdeluku alkaa tosi korkealta (2.66 kun n=500, 0.73 kun n=1000), sekä näennäisesti satunnaisia piikkejä kun suhdeluku onkin huomattavasti eri. 
![Käyrät](image.png)



## 03-TASK
Koin tämän tehtävän helpoksi, binarysearch oli helppo ymmärtää ja sen kaikki versiot helppo toteuttaa. Päätin tehdä binäärihaut iteratiivisesti.



## 04-TASK
Tehtävän tekemisessä opin miten stackit toimivat, ja sain niistä syvempää ymmärrystä. Lisäksi tiedän nyt myös JSON-tiedostojen lukemisesta enemmän mitä aiemmin. Koin tehtävän olevan haastavuustasolla tosi tasainen kaikissa tehtävän osissa, en kokenut minkään olevan liian hankalaa tai niin helppoa että olisin päässyt vähällä. Viimeisimmän bugin löytäminen pop() metodista tuotti hankaluuksia.

Aikakompleksisuusvaatimukset ovat saavuitettu, sillä kaikki O(1) metodit kestävät saman ajan suorittaa, riippumatta esimerkiksi syötöstä tai pinon senhetkisestä tilasta. kaikki O(n) aikakompleksiset metodit on myös toteutettu aikakompleksisuusrajoissa.

Jos tarkistimen saanut teksti sisältää vain yhden tai parittoman määrän lainausmerkkejä, se lukee viimeisestä lainausmerkistä koko loppu tiedoston niin kuin se kuuluisi lainausmerkkien sisälle, eikä laskisi mukaan siellä esiintyviä sulkeita. Tarkistin ei myöskään ilmoittaisi tästä käyttäjälle, joten oikeellisuus ei toteudu jos lainausmerkkejä on käytetty väärin.



## 05-TASK
Hankalimmaksi tehtävässä koin allocateSpace() methodin toteuttamisen, koska koin suuria hankaluuksia saada ymmärrykseen miten ottaisin jonon muodon (head sekä tail indeksien muuttuvat arvot) konseptin mukaan arrayn kopioon. Lopulta onnistuin, kun vähensin monimutkaisuutta ratkaisussani jota oli kertynyt liiallisen yrittelyn takia. Jonon toiminnallisuuden ymmärtäminen oli aluksi haastavaa mutta tietyn ajan kuluttua oli sisästettynä. toString oli myös hiukan haastava toteuttaa, mutta muuten en kokenut tehtävässä hankaluuksia.

Linkitettyyn listaan ei ikinä tarvitse allokoida lisää tilaa, koska jokainen uusi lisätty node sisältää viittauksen seuraavaan (mahdollisesti myös edelliseen) nodeen. Tämän takia linkitety lista ei vaadi valmiiksi määrättyä määrää tilaa muistista, vaan se kasvaa tai pienenee nodejen määrien mukaan. Samaan aikaan jonossa on vakaa määrä muistia, kunnes sitä täytyy lisätä. Riippuu käyttötarkoituksesta, kumpi sopii paremmin: jos tiedetään että elementtien lisäämistä ja poistamista tapahtuu usein, voi linkitetty lista olla parempi. Jos taas satunnainen pääsy tietoihin on tärkeämpää/useammin tapahtuvaa, luultavasti jono toimii tehokkaammin.

Kaikki methodit jotka vaativat O(1) aikakompleksisuutta ovat O(1) aikakompleksisiä, koska kaikissa niissä menee täysin sama aika suorittaa riippumatta mitä metodille syötetään. Poikkeuksena enqueue() silloin kun allocateSpace() methodia kutsutaan, koska sen aikakompleksisuus on O(n), sekä luonnollisesti toString() (jossa for-loop jokaisen jonon alkion läpi). Yhdessäkään O(1) aikakompleksisuutta vaativassa methodissa ei ole mitään silmukkaa.



## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK