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

## 03-TASK

## 04-TASK

## 05-TASK

## 06-TASK

## 07-TASK

## 08-TASK

## 09-TASK